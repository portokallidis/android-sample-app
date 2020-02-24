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
                "Χριστόφορος Κολόμβος ανακάλυψε την Αυστραλία.",
                "Ποιο έτος ξεκίνησε η Γαλλική Επανάσταση",
                "Πότε ξεκίνησε η  Γαλλική Επανάσταση?",
                "Πότε ξεκίνησε η Αναγέννηση?",
                "Τι ανακάλυψε ο Χριστόφορος Κολόμβος?"
        };

        String choices[][] = {
                {"Σωστό", "Λάθος"},
                {},
                {"12ο αιώνα", "13ό αιώνα", "14ο αιώνα", "15ο αιώνα"},
                {"1776", "1789", "1798", "1821"},
                {"Το ακρωτήριο της Καλής Ελπίδας", "Την Ινδία", "Την Αμερική", "Η γη είναι σφαιρική"}
        };

        String correctAnswer[] = {
                "Λάθος",
                "1789",
                "14ο αιώνα",
                "1789",
                "Την Αμερική"
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
                "Ποιος έγραψε την Ελληνική Νομαρχία?",
                "Πότε έγινε η πρώτη εγκατάλειψη του Σουλίου?",
                "Πότε υπογράφτηκε η συνθήκη του Κιουτσούκ Καιναρτζή?",
                "Ποιο έτος έγινε η πρώτη εγκατάλειψη του Σουλίου?",
                "Η συνθήκη του Κιουτσούκ Καιναρτζή υπογράφτηκε το 1803."
        };

        String choices[][] = {
                {"Κοσμάς ο Αιτωλός", "Ρήγας Βελεστινλής", "Ευγένιος Βούλγαρης", "Δμήτριος Καταρτζής"},
                {"1774", "1789", "1803", "1821"},
                {"1774", "1789", "1803", "1821"},
                {},
                {"Σωστό","Λάθος"}
        };

        String correctAnswer[] = {
            "Ρήγας Βελεστινλής",
                    "1803",
                    "1774",
                    "1803",
                    "Σωστό"
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
                "Ποιον μήνα έγινε η Άλωση της Τριπολιτσάς το 1821?",
                "Η επανάσταση ξεκίνησε πρώτα από __________?",
                "Τον Μάρτιο του 1821 ξεκίνησε η Ελληνική Επανάσταση από __________?",
                "Η Άλωση της Τριπολιτσάς έγινε τον Οκτώβριο του 1821.",
                "Η επανάσταση ξεκίνησε από την Τριπολιτσά."
        };

        String choices[][] = {
                {"Αύγουστο", "Σεπτέμβριο", "Ιούνιο ", "Ιούλιο"},
                {"Το Βουκουρέστι", "Την Αλαμάνα", "Την Τριπολιτσά", "Τις παραδουνάβιες ηγεμονίες"},
                {"Το Άγιο Όρος", "Το Σούλι", "Την Στερεά Ελλάδα ", "Την Πελοπόννησο"},
                {"Σωστό","Λάθος"},
                {"Σωστό","Λάθος"}
        };

        String correctAnswer[] = {
                "Σεπτέμβριο",
                "Τις παραδουνάβιες ηγεμονίες",
                "Την Πελοπόννησο",
                "Λάθος",
                "Λάθος"
        };



        return new Chapter(name,paragraphs,paragraphContent, questions,choices,correctAnswer);
    }


}
