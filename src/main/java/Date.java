/**
 * Date class takes in String inout of "xx/xx/xxxx,xxxx" type, and print our in written form.
 */
public class Date {
    protected int Day;
    protected int Month;
    protected String Year;
    protected int Time;

    /**
     * Constructor function Date takes in four Strings from user-input, store them.
     * @param Day
     * @param Month
     * @param Year
     * @param Time
     */
    public Date(String Day,String Month,String Year,String Time){
        this.Day = Integer.parseInt(Day);
        this.Month  = Integer.parseInt(Month);
        this.Year = Year;
        this.Time = Integer.parseInt(Time);
    }

    /**
     * toString function base on the four strings of date and time, convert into verbal from and displays.
     * @return String of the written form output that is ready to be printed out.
     */
    public String toString(){
        String day = Integer.toString(Day);
        if(Day % 10 == 1) {
            day = day + "st ";
        }else if(Day % 10 == 2) {
            day = day + "nd ";
        }else if(Day % 10 == 3) {
            day = day + "rd ";
        }else{
            day = day + "th ";
        }
        String month = (Month == 1) ? "January" :(Month == 2) ? "February" :(Month == 3) ? "March" :(Month == 4) ? "April" :(Month == 5) ? "May" :(Month == 6) ? "June" :(Month == 7) ? "July" :(Month == 8) ? "August" :(Month == 9) ? "September" :(Month == 10) ? "October" :(Month == 11) ? "November" :"December";
        int time1 = (Time / 100) % 12;
        int time2 = Time % 100;
        String part2 = (time2 == 0)?"":Integer.toString(time2);
        String part1 = (Time / 100 == 12)? Integer.toString(12):Integer.toString(time1);
        String time = "";
        String temp = (time2 == 0)?"":":";
        if((Time /100 )< 12 ||(Time/100) == 24){
            time = part1+temp+part2 +"am";
        }else{
            time = part1+temp+part2 + "pm";
        }
        return " "+day + "of "+month+" "+Year+", "+time+",";
    }

}
