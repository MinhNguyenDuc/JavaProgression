/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HongNhung
 */
public class CollectionJava {

    private ArrayList<Student> listStudent;

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    private void generateStudents() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("A001", "Xuân Hùng", 100000, "20/10/2018"));
        listStudent.add(new Student("A002", "Nguyễn Minh", 10000, "20/10/2018"));
        listStudent.add(new Student("A003", "Nguyễn An", 20000, "20/10/2018"));
        listStudent.add(new Student("A004", "Thu Thảo", 10000, "21/10/2018"));
        listStudent.add(new Student("A005", "Phương Anh", 20000, "21/10/2018"));
        listStudent.add(new Student("A006", "Trịnh Thúy", 40000, "22/10/2018"));
        listStudent.add(new Student("A004", "Thu Thảo", 50000, "22/10/2018"));
        listStudent.add(new Student("A004", "Thu Thảo", 60000, "23/10/2018"));
        listStudent.add(new Student("A001", "Xuân Hùng", 200000, "24/10/2018"));
        listStudent.add(new Student("A002", "Nguyễn Minh", 20000, "25/10/2018"));
        listStudent.add(new Student("A003", "Nguyễn An", 20000, "26/10/2018"));
        listStudent.add(new Student("A001", "Xuân Hùng", 50000, "27/10/2018"));
        listStudent.add(new Student("A001", "Xuân Hùng", 70000, "28/10/2018"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CollectionJava colJava = new CollectionJava();
        colJava.generateStudents();
        for (Student student : colJava.getListStudent()) {
            System.out.println(student.getName());
        }
        try {
            colJava.saveToFile();
            colJava.readFromFile();
            for(Student s : colJava.readFromFileAndSave()){
                System.out.println(s.getRollNumber());
                System.out.println(s.getName());
                System.out.println(s.getBalance());
                System.out.println(s.getDate());
                System.out.println("------------");
            }
//            for(Student s : colJava.listStudentUniqueRollNumber()){
//                System.out.println(s.getRollNumber());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveToFile() throws FileNotFoundException, IOException{
        int totalValue =0;
        FileOutputStream fos = new FileOutputStream("E:\\Project\\JavaAptech\\CollectionJava\\danhsachnoptien.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
        BufferedWriter bufferWriter = new BufferedWriter(osw);
        bufferWriter.write("Ma sinh vien \t|\t Ten sinh vien \t|\t So tien (VND) \t|\t Ngay nop");
        bufferWriter.newLine();
        bufferWriter.write("----------------------------------------------------------------------------------------------------------------------------------------------------");
        bufferWriter.newLine();
        for(int i = 0 ; i < listStudent.size(); i++){
            Student s = listStudent.get(i);
            bufferWriter.write(String.format("%15s", s.getRollNumber()));
            bufferWriter.write("\t|\t");
            bufferWriter.write(String.format("%15s", s.getName()));
            bufferWriter.write("\t|\t");
            bufferWriter.write(String.format("%15s", String.valueOf(s.getBalance())));
            bufferWriter.write("\t|\t");
            bufferWriter.write(String.format("%15s", s.getDate()));
            bufferWriter.newLine();
            totalValue+=s.getBalance();
        }
        bufferWriter.write("----------------------------------------------------------------------------------------------------------------------------------------------------");
        bufferWriter.newLine();
        bufferWriter.write(String.format("%170s", ("Tong so tien : " + totalValue + " VND")));
        bufferWriter.close();
        osw.close();
        fos.close();
    }
    
    public void readFromFile() throws FileNotFoundException, IOException{
        FileReader file = new FileReader("E:\\Project\\JavaAptech\\CollectionJava\\danhsachnoptien.txt");
        BufferedReader br = new BufferedReader(file);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        file.close();
    }
    
    public ArrayList<Student> readFromFileAndSave() throws FileNotFoundException, IOException{
        ArrayList<Student> listStudent2 = new ArrayList<Student>();
        FileReader file = new FileReader("E:\\Project\\JavaAptech\\CollectionJava\\danhsachnoptien.txt");
        BufferedReader br = new BufferedReader(file);
        String line;
        while((line = br.readLine()) != null){
           if(line.contains("|") && line.contains("(") == false){
               String str = line.trim();
               String[] words = str.split("[|]");
               for(String s : words){
                   s = s.trim();
                   System.out.println(s);
               }
               Student s = new Student(words[0].trim(), words[1].trim(), Integer.parseInt(words[2].trim()), words[3].trim());
               listStudent2.add(s);
           }
        }
        return listStudent2;
    }
    
    public HashMap<String,Student> listStudentUniqueRollNumber(){
        HashMap<String, Student> mapStudent = new HashMap<>();
        for(Student st : listStudent){
            if(mapStudent.containsKey(st.getRollNumber())){
                Student existing = mapStudent.get(st.getRollNumber());
                st.setBalance(st.getBalance() + existing.getBalance());
            }
            mapStudent.put(st.getRollNumber(), st);
        }
        return mapStudent;
    }

}
