/**
 * Duke is a interactive tool developed for users to record down calenders and tasks.
 * It also enables users to manage tasks improving their working.studying efficiency.
 */
public class Duke {
    private Storage storage;
    private Tasklist tasks;
    private Ui ui;
    private Parser parser;

    /**
     * Duke constructor method takes in the path of the txt file that will be used to store tasks.
     * @param filepath
     */
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

    /**
     * This run function contains the flow of executing Duke programme.
     * When this function is called, Duke starts/initialized and it ends when users types "bye" in the console.
     */
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

    /**
     * This is the main function that runs the programme.
     * @param args
     */
    public static void main(String[] args) {
        String currentpath = System.getProperty("user.dir");
        System.out.println(currentpath);
        new Duke(currentpath + "/docs/tasklist.txt").run();
    }
}
