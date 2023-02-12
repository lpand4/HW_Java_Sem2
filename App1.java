/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class App1 {
    public static String req = "SELECT * FROM students WHERE ";
    public static String inputData1 = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
    public static String inputData2 = "{'name':'Ivanov', 'country':'Russia', 'city':'null', 'age':'21'}";
    public static String inputData3 = "{'name':'Ivanov', 'country':'null', 'city':'Moscow', 'age':'null'}";
    public static void main(String[] args) {
        //TEST1
        String[][] dataRes1 = getData(inputData1);
        String msg1 = createRequest(dataRes1);
        System.out.println(msg1);
        //TEST2
        String[][] dataRes2 = getData(inputData2);
        String msg2 = createRequest(dataRes2);
        System.out.println(msg2);
        //TEST3
        String[][] dataRes3 = getData(inputData3);
        String msg3 = createRequest(dataRes3);
        System.out.println(msg3);        
    }

    public static String[][] getData(String inputData) {
        String[] dataRes = inputData.replace("{","")
                                    .replace("}","")
                                    .split(", ");
        String[][] res = new String[dataRes.length][];

        for (int i = 0; i < res.length; i++) {
            res[i] = dataRes[i].replace("'","")
                               .split(":");            
        }
        return res;        
    }

    public static String createRequest(String[][] data) {
        StringBuilder result = new StringBuilder(req);
            for (int i = 0; i < data.length; i++) {
                if(!data[i][1].equals("null")){
                    if (i!=0) {
                        result.append("AND ")
                              .append(data[i][0])
                              .append(" = ")
                              .append(data[i][1])
                              .append(" ");
                    }
                    else result.append(data[i][0])
                               .append(" = ")
                               .append(data[i][1])
                               .append(" ");
                }
            }
        return result.append(";").toString();
    }
    
}