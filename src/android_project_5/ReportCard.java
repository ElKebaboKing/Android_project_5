/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android_project_5;

import java.util.*;

/**
 *
 * @author es013620
 */
final class Subject
{
    private String mName;
    private int mGrade;
    
    // Constructer with subject name and grade
    public Subject(String subject, int grade)
    {
        setName(subject);
        setGrade(grade);
    }
    
    // Constructor with only the subject name
    public Subject(String subject)
    {
        setName(subject);
    }
    
    // Method that sets subject name
    public void setName(String name)
    {
        mName = name;
    }
    
    // Method that returns subject name
    public String getName()
    {
        return mName;
    }
    
    // Method that sets subject grade
    public void setGrade(int grade)
    {
        mGrade = grade;
    }
    
    // Method that returns subject grade
    public int getGrade()
    {
        return mGrade;
    }
}
public class ReportCard 
{
    
    // List that will contain the subject name and grade
    private ArrayList<Subject> mSubjects = new ArrayList<>();
    
    // List containing the subjects
    private final List<String> mSubjectNames = Arrays.asList("Maths", "English", "History", "Science", "Social Studies", "P.E.", "Art");
    
    // Constructor
    public ReportCard()
    {
        // Random variable for generating grade between 0-100
        Random rand = new Random();
        
        // Loop through all subject names, and create a new subject object for each one, and assign a new random grade to that subject.
        for(int i = 0; i < mSubjectNames.size(); i++)
            mSubjects.add(new Subject(mSubjectNames.get(i),rand.nextInt(100)));
        
    }
    
    // Adds a new subject to the subjects list with no grade
    public void addNewSubject(String subject)
    {
        mSubjects.add(new Subject(subject));
    }
    
    // Adds a new subject to the subjects list with a grade
    public void addNewSubjectWithGrade(String subject, int grade)
    {
        mSubjects.add(new Subject(subject, grade));
    }
    
    // Method that returns the grade of the given subject. 
    // Returns -1 if subject was not found.
    public int getGrade(String subject)
    {
        for (int i = 0; i < mSubjects.size(); i++)
            if(mSubjects.get(i).getName().equalsIgnoreCase(subject))
                return mSubjects.get(i).getGrade();
        return -1;
    }
    
    // Method that sets the grade of a subject.
    // Returns 1 if successful, and 0 otherwise.
    public int setGrade(String subject, int grade)
    {
        for (int i = 0; i < mSubjects.size(); i++)
            if(mSubjects.get(i).getName().equalsIgnoreCase(subject))
            {
                mSubjects.get(i).setGrade(grade);
                return 1;
            }
        return 0;
    }
    
    @Override
    public String toString()
    {
        String output = "Report Card:";
        for (int i = 0; i < mSubjects.size();i++)
            output += "\n" + mSubjects.get(i).getName() + ": " 
                    + mSubjects.get(i).getGrade();
        return output;
    }
    
}
