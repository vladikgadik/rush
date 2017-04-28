package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer,Contact {
        public IncomeDataAdapter(IncomeData data){
            this.data=data;
        }
        private IncomeData data;
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String codeOut;
            int codeIn = data.getPhoneNumber()/10000000;
            if (codeIn==0){
                codeOut="000";
            }else if (codeIn<10){
                codeOut="00"+String.valueOf(codeIn);
            }else if(codeIn<100){
                codeOut="0"+String.valueOf(codeIn);
            }else{
                codeOut=String.valueOf(codeIn);
            }
            int tel=data.getPhoneNumber()-codeIn*10000000;
            int tel1=tel/10000;
            String tel11;
            String tel22;
            String tel33;
            if (tel1==0){
                    tel11 ="000";
            }else if (tel1<10){
                     tel11 ="00"+String.valueOf(tel1);
            }else if (tel1<100){
                     tel11 ="0"+String.valueOf(tel1);
            }else{
                     tel11 =String.valueOf(tel1);
            }
            int tel2=(tel-tel1*10000)/100;
            if (tel2==0){
                tel22 ="00";
            }else if (tel2<10){
                tel22 ="0"+String.valueOf(tel2);
            }else{
                tel22 =String.valueOf(tel2);
            }
            int tel3 = tel%100;
            if (tel3==0){
                tel33 ="00";
            }else if (tel3<10){
                tel33 ="0"+String.valueOf(tel3);
            }else{
                tel33 =String.valueOf(tel3);
            }
            return  "+"+data.getCountryPhoneCode()+"("+codeOut+")"+tel11+"-"+tel22+"-"+tel33;
        }
    }



    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}