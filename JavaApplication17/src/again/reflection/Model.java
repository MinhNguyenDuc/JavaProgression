/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package again.reflection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class Model {

    public static void main(String[] args) throws SQLException {
        Model model = new Model();
        Customer cus = new Customer("Hung");
        Student st = new Student("Xuan Hung", "A0213");
        model.save(st);
        System.out.println("----");
        model.save(cus);
    }
    
    public void saveOptimize(Object obj){
        
    }
    
    public String getTableName(Object obj){
        return obj.getClass().getSimpleName();
    }
    
    public void getFieldName(Object obj){
        Field[] listField = obj.getClass().getDeclaredFields();
    }
    
    public void save(Object obj) throws SQLException {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder fieldsValueBuilder = new StringBuilder();
        fieldsValueBuilder.append("(");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);

                System.out.println(f.getName() + " - " + f.getType().getSimpleName());
                System.out.println(f.isAnnotationPresent(MyId.class));
                if (f.isAnnotationPresent(MyId.class) && f.isAnnotationPresent(AutoGenerate.class)) {
                    continue;
                }
                if (f.getType().getSimpleName().equals("String")) {
                    fieldsValueBuilder.append("'").append(f.get(obj)).append("'").append(",");
                } else if (f.getType().getSimpleName().equals("int")) {
                    fieldsValueBuilder.append(f.get(obj)).append(",");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        fieldsValueBuilder.deleteCharAt(fieldsValueBuilder.length() - 1);
        fieldsValueBuilder.append(")");
        System.out.println(fieldsValueBuilder.toString());

        String tableName = obj.getClass().getSimpleName().toLowerCase();
        StringBuilder fieldsNameBuilder = new StringBuilder();
        fieldsNameBuilder.append("(");
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            if (f.isAnnotationPresent(MyId.class) && f.isAnnotationPresent(AutoGenerate.class)) {
                continue;
            }
            fieldsNameBuilder.append(f.getName()).append(",");
        }
        fieldsNameBuilder.deleteCharAt(fieldsNameBuilder.length() - 1);
        fieldsNameBuilder.append(")");
        String fieldsName = fieldsNameBuilder.toString();
        String fieldsValue = fieldsValueBuilder.toString();

        Statement stt = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/reflection", "root", "")
                .createStatement();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into ")
                .append(tableName)
                .append(" ")
                .append(fieldsName)
                .append(" ")
                .append("values ")
                .append(fieldsValue);
        System.out.println(sqlBuilder.toString());
        stt.execute(sqlBuilder.toString());
    }
}
