package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
     List list=   detectAllWords(crossword, "home", "same","lse","rek");
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int i=0;i<words.length;i++) {
            char[] word = words[i].toCharArray();
            int[][] end;
            for (int j=0;j<crossword.length;j++){
                for (int k=0;k<crossword[j].length;k++){
                    if (crossword[j][k]==word[0]&&word.length>1){
                        end = search(crossword,word,j,k);
                        if (end !=null){
                            for (int m=0;m<end.length;m++) {
                                if (end[m]!=null) {
                                    Word wordd = new Word(words[i]);
                                    wordd.setStartPoint(k, j);
                                    wordd.setEndPoint(end[m][1], end[m][0]);
                                    list.add(wordd);
                                }
                            }
                        }

                    }
                }
            }

            char s;
            for (int f=0;f<word.length/2;f++){
                s=word[f];
                word[f]=word[word.length-(1+f)];
                word[word.length-(1+f)]=s;
            }

            for (int j=0;j<crossword.length;j++){
                for (int k=0;k<crossword[j].length;k++){
                    if (crossword[j][k]==word[0]&&word.length>1){
                        end = search(crossword,word,j,k);
                        if (end !=null){
                            for (int m=0;m<end.length;m++) {
                                if (end[m]!=null) {
                                    Word wordd = new Word(words[i]);
                                    wordd.setEndPoint(k, j);
                                    wordd.setStartPoint(end[m][1], end[m][0]);
                                    list.add(wordd);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static int[][] search(int[][] crossword,char[] word,int j,int k){
        int[][] end=new int[4][2];
                end[0] = checkRight(crossword, word, 0, j, k);
                end[1] = checkAcrossRight(crossword, word, 0, j, k);
                end[2] = checkDown(crossword, word, 0, j, k);
                end[3] = checkAcrossLeft(crossword, word, 0, j, k);
        return end;
    }

    public static int[] checkRight(int[][] crossword,char[] word,int count,int j,int k){
        int[] result=new int[2];
            if ((word.length==1+count)||(k+1+count==crossword[j].length)||(crossword[j][k+1+count]!=word[1+count])){
                if (word.length>1+count){
                    result=null;
                }else {
                    result[0] = j;
                    result[1] = k + count;
                }
            }else{
                result=checkRight(crossword,word,count+1,j,k);
            }
        return result;
    }
    public static int[] checkAcrossRight(int[][] crossword,char[] word,int count,int j,int k){
        int[] result=new int[2];
        if ((word.length==1+count)||(j+1+count==crossword.length)||(k+1+count==crossword[j].length)||(crossword[j+1+count][k+1+count]!=word[1+count])){
            if (word.length>1+count){
                result=null;
            }else {
                result[0] = j + count;
                result[1] = k + count;
            }
        }else{
            result=checkAcrossRight(crossword,word,count+1,j,k);
        }
        return result;
    }

    public static int[] checkDown(int[][] crossword,char[] word,int count,int j,int k){
        int[] result=new int[2];
        if ((word.length==1+count)||(j+1+count==crossword.length)||(crossword[j+1+count][k]!=word[1+count])){
            if (word.length>1+count){
                result=null;
            }else {
                result[0] = j + count;
                result[1] = k;
            }
        }else{
            result=checkDown(crossword,word,count+1,j,k);
        }
        return result;
    }

    public static int[] checkAcrossLeft(int[][] crossword,char[] word,int count,int j,int k){
        int[] result=new int[2];
            if ((word.length == 1 + count) || (j + 1 + count == crossword.length) || ((k - 1 - count) < 0) || (crossword[j + 1 + count][k - 1 - count] != word[1 + count])) {
                if (word.length > 1 + count) {
                    result = null;
                } else {

                    result[0] = j + count;
                    result[1] = k - count;
                }
            } else {
                result = checkAcrossLeft(crossword, word, count + 1, j, k);
            }
        return result;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
