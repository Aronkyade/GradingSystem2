/*
 * Author : Aderonke Adebayo
 * Date : 11/12/2019
 * Project : Project 2
 */



import java.util.InputMismatchException;
import java.util.Scanner;

public class GradingSystem {

    static Scanner input = new Scanner(System.in);
    private float Assignment[];
    private float Project[];
    private float Quiz[];
    private float Exam[];
    private final  float Participation;
    public GradingSystem(float array1[],float array2[],float array3[], float array4[], float participation){
        this.Assignment=array1;
        this.Project = array2;
        this.Quiz = array3;
        this.Exam = array4;
        this.Participation = participation;
    }
    public String getGrade(float FinalResult){
        int Lettergrade = (int) (FinalResult);
        String letterGrade;
        switch (Lettergrade) {
            case 1:
                letterGrade = "A";
                if(FinalResult>=93)
                break;
            case 2:
                letterGrade = "A-";
                if(FinalResult>90)
                    break;
            case 3:
                letterGrade = "B+";
                if(FinalResult>=87)
                    break;
            case 4:
                letterGrade = "B";
                if(FinalResult>=83)
                    break;
            case 5:
                letterGrade = "B-";
                if(FinalResult>80)
                    break;
            case 6:
                letterGrade = "C+";
                if(FinalResult>=77)
                    break;
            case 7:
                letterGrade = "C";
                if(FinalResult>=73)
                    break;
            case 8:
                letterGrade = "C-";
                if(FinalResult>70)
                    break;
            case 9:
                letterGrade = "D+";
                if(FinalResult>=67)
                    break;
            case 10:
                letterGrade = "D";
                if(FinalResult>=63)
                    break;
            case 11:
                letterGrade = "D-";
                if(FinalResult>60)
                    break;
            default:
                letterGrade = "F";
        }
        return letterGrade;
    }
    public float CalculateResult(){
        float result= 0;
        float FinalResult= 0;
        if(this.Assignment.length>0 && this.Assignment.length<=5)
        {
            for(int i=0;i<this.Assignment.length;i++)
            {
                result+=this.Assignment[i];
            }
            FinalResult=result/150*30;
        }
        result=0;
        if(this.Quiz.length>0 && this.Quiz.length<=5)
        {
            for(int i=0;i<this.Quiz.length;i++)
            {
                result+=this.Quiz[i];
            }
            FinalResult += result/100*20;
        }
        result=0;
        if(this.Exam.length>0 && this.Exam.length<=2)
        {
            for(int i=0; i<this.Exam.length; i++)
            {
                result+=this.Exam[i];
            }
            FinalResult += result/100*20;
        }
        result=0;
        if(this.Project.length>0 && this.Project.length<=3)
        {
            for(int i = 0;i < this.Project.length; i++)
            {
                result += this.Project[i];
            }
            FinalResult+=result/600*20;
        }
        FinalResult+=this.Participation/50*10;
        return FinalResult;
    }
    public void print(int n1,int n2,int n3, int n4, float result){
        System.out.println("You did "+n1+" out of 5 Assignments in this class this semester");
        System.out.println("You did "+n2+" out of 5 Quizzes in this class this semester");
        System.out.println("You did "+n3+" out of 3 Projects in this class this semester");
        System.out.println("You did "+n4+" out of 2 Exams (Midterm and Final) in this class this semester");
        System.out.println("You scored a total of "+result+"% and your grade for this class is: "+getGrade(result));
    }
    public static int GetAnInteger(){
        while (true)
        {
            try
            {
                return input.nextInt();
            }
            catch (InputMismatchException e)
            {
                input.next();
                System.out.print("That is not an integer. Try again: ");
            }
        }
    }
    public static float GetAFloat(){
        while (true)
        {
            try
            {
                return input.nextFloat();
            }
            catch (InputMismatchException e)
            {
                input.next();
                System.out.print("That’s not a Float. Try again: ");
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("******* Java class grade calculating system using a syllabus specification *******\n");
        System.out.print("How many assignment did you have for this class? ");
        int noOfAsg=GetAnInteger();

        while(noOfAsg<=0 || noOfAsg>5)
        {
            System.out.println("Error. You have to choose a number from 1 to 5");
            noOfAsg=GetAnInteger();
        }
        float  assign[]=new float[noOfAsg];
        for(int i=0;i<noOfAsg;i++)
        {
            System.out.print("Enter obtained Marks of Assignment "+(i+1)+": "); //Get score from user for each assignment
            assign[i]=GetAFloat();
        }
        System.out.print("How many Projects did you have for this class?  ");
        int noOfProj=GetAnInteger();
        while(noOfProj<=0 || noOfProj>3)
        {
            System.out.println("Error. You have to choose a number from 1 to 3");
            noOfProj=GetAnInteger();
        }
        float proj[]=new float[noOfProj];
        for(int i=0;i<noOfProj;i++)
        {
            System.out.print("Enter Obtained Marks of Project "+(i+1)+": "); //Get score from user for each Project
            proj[i]=GetAFloat();
        }
        System.out.print("How many quiz did you have for this class?  ");
        int noOfQuiz=GetAnInteger();
        while(noOfQuiz<=0 || noOfQuiz>5)
        {
            System.out.println("Error. You have to choose a number from 1 to 5");
            noOfQuiz=GetAnInteger();
        }
        float quiz[]=new float[noOfQuiz];
        for(int i=0;i<noOfQuiz;i++)
        {
            System.out.print("Enter Obtained Marks of Quiz "+(i+1)+": "); //Get score from user for each Quiz
            quiz[i]=GetAFloat();
        }
        System.out.print("How many Exam did you have for this class?  ");
        int noOfExam=GetAnInteger();
        while(noOfExam<=0 || noOfExam>2)
        {
            System.out.println("Error. You have to choose either 1 or 2");
            noOfQuiz=GetAnInteger();
        }
        float Exam[]=new float[noOfExam];
        for(int i=0;i<noOfExam;i++)
        {
            System.out.print("Enter Obtained Marks of Exam "+(i+1)+": "); //Get score from user for each Exam
            quiz[i]=GetAFloat();
        }
        System.out.print("Enter Obtained Marks of Participation: ");
        float obtainedMarksOfPart=GetAFloat();
        GradingSystem javaClass = new GradingSystem(assign,proj,quiz,Exam,obtainedMarksOfPart);
        float myResult=javaClass.CalculateResult();
        javaClass.print(noOfAsg, noOfQuiz, noOfProj, noOfExam, myResult);
    }
}