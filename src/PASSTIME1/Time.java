/**
 *
 *  @author Dobosz Kacper S18903
 *
 */

package PASSTIME1;


import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {

    public static String passed(String s, String s1) {
        Time t = new Time();


        if (t.checker(s).contains("*")) {
            return t.checker(s);
        } else if (t.checker(s1).contains("*")) {
            return t.checker(s1);
        } else {
            if (s.contains("T") && s1.contains("T")) {
                LocalDateTime localDateTimeS = LocalDateTime.parse(s);
                ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTimeS, ZoneId.of("Europe/Warsaw"));
                LocalDateTime localDateTimeS1 = LocalDateTime.parse(s1);
                ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTimeS1, ZoneId.of("Europe/Warsaw"));

                String firstLine = "Od " + zonedDateTime.getDayOfMonth() + " "
                        + zonedDateTime.getMonth().getDisplayName(TextStyle.FULL, new Locale("pl", "PL"))
                        + " " + zonedDateTime.getYear() + " (" +
                        zonedDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pl", "PL")) + ") do " + zonedDateTime2.getDayOfMonth() + " "
                        + zonedDateTime2.getMonth().getDisplayName(TextStyle.FULL, new Locale("pl", "PL"))
                        + " " + zonedDateTime2.getYear() + " (" +
                        zonedDateTime2.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pl", "PL")) + ")";


                double roundOff =(double) Math.round(ChronoUnit.DAYS.between(zonedDateTime,zonedDateTime2)) / 7;
                String secondLine = "- mija: "+ ChronoUnit.DAYS.between(zonedDateTime,zonedDateTime2) + " dni, tygondi "+ new DecimalFormat("0.00").format(roundOff) +"\n"+
                "- godzin: "+ ChronoUnit.HOURS.between(zonedDateTime,zonedDateTime2) + ", minut: "+ ChronoUnit.MINUTES.between(zonedDateTime,zonedDateTime2)+"\n";

                String thirdLine = "- kalendarzowo: ";
                LocalDate a = LocalDate.from(localDateTimeS);
                LocalDate b  = LocalDate.from(localDateTimeS1);
                Period p = Period.between(a, b);

                int years = p.getYears();
                int months = p.getMonths();
                int days = p.getDays();
                if(years==1){
                    thirdLine = thirdLine+  years+" rok, ";
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>2){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }else if(years<1){
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>1){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }else if(years>1){
                    thirdLine = thirdLine+  years+" lata ";
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>1){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }


                return firstLine +"\n"+ secondLine +thirdLine;
            } else {
                LocalDate localDates = LocalDate.parse(s);
                LocalDate localDateS1 = LocalDate.parse(s1);
                String firstLine = "Od " + localDates.getDayOfMonth() + " "
                        + localDates.getMonth().getDisplayName(TextStyle.FULL, new Locale("pl", "PL"))
                        + " " + localDates.getYear() + " (" +
                        localDates.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pl", "PL")) + ") do " + localDateS1.getDayOfMonth() + " "
                        + localDateS1.getMonth().getDisplayName(TextStyle.FULL, new Locale("pl", "PL"))
                        + " " + localDateS1.getYear() + " (" +
                        localDateS1.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pl", "PL")) + ")";


                double roundOff =(double) Math.round(ChronoUnit.DAYS.between(localDates,localDateS1)) / 7;
                String secondLine = "- mija: "+ ChronoUnit.DAYS.between(localDates,localDateS1) + " dni, tygondi "+ new DecimalFormat("0.00").format(roundOff);

                String thirdLine = "- kalendarzowo: ";

                Period p = Period.between(localDates, localDateS1);

                int years = p.getYears();
                int months = p.getMonths();
                int days = p.getDays();
                if(years==1){
                    thirdLine = thirdLine+  years+" rok, ";
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>2){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }else if(years<1){
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>1){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }else if(years>1){
                    thirdLine = thirdLine+  years+" lata, ";
                    if(months==1){
                        thirdLine = thirdLine+months+ " miesiąc, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months<1){
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }else if(months>1){
                        thirdLine = thirdLine+ months+ " miesiące, ";
                        if(days==1){
                            thirdLine = thirdLine+days+ " dzień";
                        }else if(days<1){

                        }else{
                            thirdLine = thirdLine+ days+ " dni";
                        }
                    }
                }

                return firstLine +"\n"+ secondLine +"\n"+thirdLine;
            }
        }
    }


    public String checker(String s){
        if (s.contains("T")) {
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(s);
                return localDateTime.toString();
            } catch (DateTimeParseException e) {
                return "*** " +e+" " + e.getMessage();
            }
        } else {
            try {
                LocalDate localDate = LocalDate.parse(s);
                return localDate.toString();
            } catch (DateTimeParseException e) {
                return "*** " +e+" " + e.getMessage();
            }
        }
    }
}