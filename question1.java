import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class question1{
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<String, Integer> keywords = new HashMap<>();

    public static void main(String args[]) throws IOException {
        in_Map();
        File file = new File("/Users/anwar/Desktop/PLC final/text");

        BufferedReader br = new BufferedReader(new FileReader(file));
        List<List<String>> parsedFileArray = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null)
        {
            // Print the string
            //System.out.println(line);
            String[] arr = line.split("\\s* \\s*");

            List<String> ls = new ArrayList<>();
            
            for(int i = 0; i<arr.length; i++){
                if(!arr[i].equals("")){
                    ls.add(arr[i]);
                }
            }

            parsedFileArray.add(ls);

        }

        for(int i = 0; i < parsedFileArray.size(); i++){
            CheckCode(parsedFileArray.get(i));
        }
    }    

    static void in_Map(){

        map.put("class",1);
        map.put("public",2);
        map.put("{",3);
        map.put("}",4);
        map.put("(",5);
        map.put(")",6);
        map.put(">>",7);
        map.put("=",8);
        map.put("==",9);
        map.put("+",10);
        map.put("if",11);
        map.put("void",11);
        map.put("boolean",12);
        map.put("String",13);
        map.put("private",14);

        keywords.put("class",1);
        keywords.put("public", 2);
        keywords.put("private",3);
        keywords.put("void",4);
        keywords.put("main",5);
        keywords.put("String",6);
        keywords.put("float",7);
        keywords.put("boolean",8);
        keywords.put("int",9);
        keywords.put("if",10);

    }

    private static void CheckCode(List<String> arr){
        checkClassStructure(arr);
        checkPremitiveDataConstruction(arr);
        CheckIfStatement(arr);
        CheckFunction(arr);
        Class_dereferencing(arr);
    }

    
    private static void checkClassStructure(List<String> arr){

        if(arr.size() > 3)
        if(keywords.containsKey(arr.get(0)) && keywords.containsKey(arr.get(1)) && arr.get(3).equals("{")){
            printArray(arr);
            PrintKeyword(arr.get(0));

            if(keywords.containsKey(arr.get(0))){
                print(" > Class is constructed correctly");
            }else{
                print(" > Class is NOT constructed correctly");
            }
        }

    }

    private static void checkPremitiveDataConstruction(List<String> arr){
        
        if(arr.size() > 4){

            if(arr.get(0).equals("boolean")){
                printArray(arr);
                PrintKeyword(arr.get(0));
                if(arr.get(2).equals("=") && arr.get(4).equals(";") && arr.get(3).equals("true") || arr.get(4).equals("false")){
                    print(" > Boolean is decalared correctly");
                }else{
                    print(" > Boolean is not decalared correctly");
                }

            }
            if(arr.get(0).equals("int")){
                printArray(arr);
                PrintKeyword(arr.get(0));

                if(arr.get(2).equals("=") && arr.get(4).equals(";") && isInt(arr.get(3))){
                    print(" > int is decalared correctly");
                }else{

                    print(" > int is not decalared correctly");
                }

            }

            if(arr.get(0).equals("float")){
                printArray(arr);
                PrintKeyword(arr.get(0));

                if(arr.get(2).equals("=") && arr.get(4).equals(";") && isFloat(arr.get(3))){
                    print(" > float is decalared correctly");
                }else{
                    print(" > float is not decalared correctly");
                }

            }

        }
        


    }

    private static void CheckIfStatement(List<String> arr){

        if(arr.size() > 3)
        if(arr.get(0).equals("if")){
            printArray(arr);

            PrintKeyword("if");
            System.out.println(arr);
            if(arr.contains("(") && arr.contains(")")){
                print(" > if is constructed correctly");

            }else{
                print(" > if is not constructed correctly");
            }

        }

    }

    private static void CheckFunction(List<String> arr){

        if(arr.size() > 5){
            int n = arr.size()-1;
            if(keywords.containsKey(arr.get(0)) && keywords.containsKey(arr.get(1)) && !arr.get(1).equals("class")){
                printArray(arr);
                PrintKeyword(arr.get(0));
                PrintKeyword(arr.get(1));

                if(arr.contains("(") && arr.contains(")") && arr.contains("{")){
                    print(" > this method is constructed correctly");
                }else{
                    print(" > this method is not constructed correctly");

                }
            }
        }

    }

    private static void Class_dereferencing(List<String> arr){

        if(arr.size() > 2){
            if(arr.get(2).contains(".")){//function with potential return type
                
                printArray(arr);
                int n = arr.size()-1;

                if(arr.get(3).equals("(") && arr.get(n-1).equals(")") && arr.get(n).equals(";")){
                    print(" > Class Dereferencing is constructed correctly");
                }else{
                    print(" > Class Dereferencing is NOT constructed correctly");
                }

            }else if(arr.get(0).contains(".")){
                printArray(arr);

                if(arr.get(1).equals("=") && arr.get(arr.size()-1).equals(";")){
                    print(" > Class Dereferencing is constructed correctly");

                }else{
                    print(" > Class Dereferencing is NOT constructed correctly");
                }
                

            }
        }

    }

    private static void PrintKeyword(String s) {
        System.out.println(" > Keyword is " + s + " token # is " + keywords.get(s));
    }

    private static void printArray(List<String> arr) {
        String s = "";

        for(int i = 0; i < arr.size(); i++){
            s += arr.get(i) + " ";
        }
        System.out.println(s);

    }

    private static void print(String s){
        System.out.println(s);
    }

    private static boolean isInt(String s){
         Pattern pattern = Pattern.compile("-?\\d+?");

         return pattern.matcher(s).matches();

    }
    private static boolean isFloat(String s){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        return pattern.matcher(s).matches();

   }
}