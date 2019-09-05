public class Duke {
    private Storage storage;
    private Tasklist tasks;
    private Ui ui;
    private Parser parser;

    public Duke(String filepath) {
        ui = new Ui();
        storage = new Storage(filepath);
        try {
            tasks = new Tasklist(storage.load());
        } catch (Exception e) {   //这里用的还是Exception 不是DukeException
            ui.showLoadingError();
            tasks = new Tasklist();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                parser = new Parser();
                Command c = new Command(parser.parseType(fullCommand),parser.parseContent(fullCommand));
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (Exception e) {   //这里用的还是Exception 不是DukeException
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("./docs/tasklist.txt").run();
    }
}
