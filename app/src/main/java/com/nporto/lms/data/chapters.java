package com.nporto.lms.data;

import com.nporto.lms.R;
import com.nporto.lms.model.Chapter;

import java.util.ArrayList;

public class chapters {
    ArrayList<Chapter> chapters;

    public ArrayList<Chapter> getData() { return chapters; }
    public String[] getChapters() {
        int len = chapters.size();
        String[] titles = new String[len];
        for(int i=0; i<len; i++){
            titles[i] = chapters.get(i).name;
        }
        System.out.println(titles);
        return titles;
    }


    public chapters() {
        ArrayList<Chapter> data = new ArrayList<>();
        data.add(chapter1());
        data.add(chapter2());
        data.add(chapter3());
        this.chapters = data;
    }





    /*  =========== DATA ENTRY ============ */

    static Chapter chapter1() {
        String name = "Α. Οι εξελίξεις στην Ευρώπη κατά τους Νεότερους Χρόνους";
        String paragraphs[] = {
                "1. Η Αναγέννηση και η θρησκευτική Μεταρρύθμιση",
                "2. Από τις Γεωγραφικές Ανακαλύψεις στο Διαφωτισμό",
                "3. Η Αμερικανική και η Γαλλική Επανάσταση"
        };
        int paragraphContent = R.array.chapter1_paragraphs;

        String questions[] = {
                "Which is a Programming Language?",
                "In COMAL language program, after name of procedure parameters must be in?",
                "Programming language COBOL works best for use in?"
        };

        String choices[][] = {
                {"HTML", "CSS", "Vala", "PHP"},
                {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
                {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}
        };

        String correctAnswer[] = {
                "PHP",
                "Brackets",
                "Commercial Applications"
        };


        return new Chapter(name,paragraphs,paragraphContent, questions,choices,correctAnswer);
    }

    static Chapter chapter2() {
        String name = "Β. Οι Έλληνες κάτω από την οθωμανική και τη λατινική κυριαρχία";

        String paragraphs[] = {
                "1. Η κατάκτηση της ελληνικής Χερσονήσου",
                "2. Οι συνθήκες ζωής των υποδούλων",
                "3. Η θρησκευτική και η πολιτική οργάνωση των Ελλήνων",
                "4. Οι Κλέφτες και οι Αρματολοί",
                "5. Η οικονομική ζωή"
        };
        int paragraphContent = R.array.chapter2_paragraphs;

        String questions[] = {
                "Which is a Programming Language?",
                "In COMAL language program, after name of procedure parameters must be in?",
                "Programming language COBOL works best for use in?"
        };

        String choices[][] = {
                {"HTML", "CSS", "Vala", "PHP"},
                {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
                {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}
        };

        String correctAnswer[] = {
                "PHP",
                "Brackets",
                "Commercial Applications"
        };


        return new Chapter(name,paragraphs,paragraphContent, questions,choices,correctAnswer);
    }

    static Chapter chapter3() {
        String name = "Γ. Η Μεγάλη Επανάσταση";

        String paragraphs[] = {
                "1. Η Φιλική Εταιρεία",
                "2. Η εξέγερση στη Μολδοβλαχία",
                "3. Η επανάσταση στην Πελοπόννησο",
                "4. Η επανάσταση στη Στερεά Ελλάδα"
        };
        int paragraphContent = R.array.chapter3_paragraphs;
        String questions[] = {
                "Which is a Programming Language?",
                "In COMAL language program, after name of procedure parameters must be in?",
                "Programming language COBOL works best for use in?"
        };

        String choices[][] = {
                {"HTML", "CSS", "Vala", "PHP"},
                {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
                {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}
        };

        String correctAnswer[] = {
                "PHP",
                "Brackets",
                "Commercial Applications"
        };


        return new Chapter(name,paragraphs,paragraphContent, questions,choices,correctAnswer);
    }


}
