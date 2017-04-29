package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        //Test
        Customer customer = new Customer() {
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            public String getName() {
                return "Ivanov, Ivan";
            }

            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        RowItem rowItem = new DataAdapter(customer, contact);
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
    }

    public static class DataAdapter implements RowItem {
        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }
        private Customer customer;
        private Contact contact;

        @Override
        public String getCountryCode() {
            String result=null;
            for (Map.Entry<String,String> map:countries.entrySet()) {
                if (map.getValue().equals(customer.getCountryName())){
                    result=map.getKey();
                }
            }
            return result;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String name = contact.getName().split(", ")[1];
            return name;
        }

        @Override
        public String getContactLastName() {
            String name = contact.getName().split(", ")[0];
            return name;
        }

        @Override
        public String getDialString() {
            String result = "callto://+"+contact.getPhoneNumber().replaceAll("\\D","");
            return result;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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