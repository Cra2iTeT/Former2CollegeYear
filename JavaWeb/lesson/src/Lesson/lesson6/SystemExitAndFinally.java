package Lesson.lesson6;

public class SystemExitAndFinally {


    public static void main(String[] args){

        try {


            System.out.println("in main");

            try {
                throw new Exception("Exception is thrown in main");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.exit(0);


        } /*catch (Exception e) {

            System.out.println(e.getMessage());

            System.exit(0);

        } */finally {

            System.out.println("in finally");

        }

    }


}