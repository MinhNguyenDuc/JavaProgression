/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigModel;

import annotation.FieldToDelete;
import annotation.FieldValueFromGetterMethod;
import annotation.TableField;
import entity.Customer;
import entity.Student;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nguye
 * @param <T>
 */
public class BigModel<T> {
    private Class<T> clazz;

    public Class<T> getClazz() {
        return clazz;
    }

    public BigModel(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public String getTableName(){
        return this.clazz.getSimpleName();
    }
    
    public String getAllFieldNameForInsert(){
        Field[] declareFields = this.clazz.getDeclaredFields();
        ArrayList<String> databaseAnnotationFieldNameSorted = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(Field f : declareFields){
            f.setAccessible(true);
            if(f.isAnnotationPresent(TableField.class)){
                databaseAnnotationFieldNameSorted.add(f.getName());
            }
        }
        Collections.sort(databaseAnnotationFieldNameSorted);
        for(int i = 0 ; i < databaseAnnotationFieldNameSorted.size()-1;i++){
            sb.append(databaseAnnotationFieldNameSorted.get(i));
            sb.append(", ");
        }
        sb.append(databaseAnnotationFieldNameSorted.get(databaseAnnotationFieldNameSorted.size()-1));
        return sb.toString();
    }
    
    public String getAllFieldDatabaseValueForInsert(T obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        Class cls = obj.getClass();
        Method[] listMethod = cls.getDeclaredMethods();
        ArrayList<String> listMethodName = new ArrayList<String>();
        for(Method m : listMethod){
            m.setAccessible(true);
            if(m.isAnnotationPresent(FieldValueFromGetterMethod.class)){
                listMethodName.add(m.getName());
            }
        }
        Collections.sort(listMethodName);
        ArrayList<Method> databaseGetterValue = new ArrayList<Method>();
        for(String mName : listMethodName){
            for(Method m : listMethod){
                if(mName.equals(m.getName())){
                    databaseGetterValue.add(m);
                }
            }
        }
        for(int i = 0 ; i < databaseGetterValue.size()-1;i++){
            sb.append("'").append((String)databaseGetterValue.get(i).invoke(obj)).append("', ");
        }
        sb.append("'").append((String)databaseGetterValue.get(databaseGetterValue.size()-1).invoke(obj)).append("'");
        return sb.toString();
    }
    
    
    public boolean insert(T obj) throws IllegalAccessException, InvocationTargetException, SQLException {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append(this.clazz.getSimpleName());
            sb.append(" (");
            sb.append(this.getAllFieldNameForInsert());
            sb.append(") VALUES (");
            sb.append(getAllFieldDatabaseValueForInsert(obj));
            sb.append(")");
            String sql = sb.toString();
            Statement st = connection.createStatement();
            st.execute(sql);
            System.out.println(sql);
            return true;
    }
    
    public String deleteField() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        StringBuilder sb = new StringBuilder();
        Field[] listFields = this.clazz.getDeclaredFields();
        for(Field f : listFields){
            f.setAccessible(true);
            if(f.isAnnotationPresent(FieldToDelete.class)){
                sb.append(f.getName());
            }
        }
        return sb.toString();
    }
    
    public boolean delete(String deleteValue)throws Exception{
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ");
            sb.append(this.clazz.getSimpleName());
            sb.append(" WHERE ");
            sb.append(deleteField());
            sb.append(" = '").append(deleteValue).append("'");
            Statement stm = connection.createStatement();
            stm.execute(sb.toString());
            System.out.println(sb.toString());
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").append(this.clazz.getSimpleName());
            sb.append(" SET ");
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        BigModel<Student> bms = new BigModel<>(Student.class);
        BigModel<Customer> bmc = new BigModel<>(Customer.class);
        
        try {
            bms.delete("AC1");
            bmc.delete("Minh1");
        } catch (Exception e) {
        }
    }
    
}
