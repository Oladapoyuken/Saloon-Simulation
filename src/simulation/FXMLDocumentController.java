/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Yuken4real
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField numberField;

    @FXML
    private TextField initialField;

    @FXML
    private ListView<String> pageList;


    
    public List<Float> gen = new ArrayList<>();
    public ObservableList<Float> obList = FXCollections.observableArrayList();
    public ObservableList<String> members = FXCollections.observableArrayList();
    public String[] matricNumbers = {
        "1.    130083","2.    141208","3.    133915","4.    131773","5.    130679",
        "6.    132474","7.    132072","8.    133448","9.    133574","10.    143984",
        "11.    133200","12.    130279","13.    130944","14.    130708","15.    132184",
        "16.    133581","17.    131221","18.    131860","19.    124672","20.    132802"
    };
    
    public int radNum, initNum;
    
    @FXML
    private Button proOneBut;
    @FXML
    private Button proTwoBut;
    @FXML
    private TableView<placementList> tableOne;
    @FXML
    private Button backOneBut;
    @FXML
    private Button printOneBut;
    @FXML
    private TableView<placementList2> tableTwo;
    @FXML
    private Button backTwoBut;
    @FXML
    private Button printTwoBut;
    @FXML
    private Button finishBut;
    @FXML
    private TableColumn<placementList, String> colOne;
    @FXML
    private TableColumn<placementList, String> colTwo;
    @FXML
    private TableColumn<placementList, String> colThree;
    @FXML
    private TableColumn<placementList, String> colFour;
    @FXML
    private TableColumn<placementList, String> colFive;
    @FXML
    private TableColumn<placementList, String> colSix;
    
    @FXML
    private TableColumn<placementList2, String> colOne2;
    @FXML
    private TableColumn<placementList2, String> colTwo2;
    @FXML
    private TableColumn<placementList2, String> colThree2;
    @FXML
    private TableColumn<placementList2, String> colFour2;
    @FXML
    private TableColumn<placementList2, String> colFive2;
    @FXML
    private TableColumn<placementList2, String> colSix2;
    @FXML
    private TableColumn<placementList2, String> colSeven2;
    
    @FXML
    private AnchorPane pageOne;
    @FXML
    private AnchorPane pageTwo;
    @FXML
    private AnchorPane pageThree;
    
    
    List<Float> upper = new ArrayList<>();
    List<Float> down = new ArrayList<>();
    List<Float> clock = new ArrayList<>();
    
    public DecimalFormat f = new DecimalFormat("##.000");
    public int ctr = 0, ctr2 = 0;
    
    double temppp = 0;
    @FXML
    private AnchorPane mainFrame;
    @FXML
    private Label note1;
    @FXML
    private Label note2;
    
    
    
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colOne.setCellValueFactory(new PropertyValueFactory<placementList, String>("one"));
        colTwo.setCellValueFactory(new PropertyValueFactory<placementList, String>("two"));
        colThree.setCellValueFactory(new PropertyValueFactory<placementList, String>("three"));
        colFour.setCellValueFactory(new PropertyValueFactory<placementList, String>("four"));
        colFive.setCellValueFactory(new PropertyValueFactory<placementList, String>("five"));
        colSix.setCellValueFactory(new PropertyValueFactory<placementList, String>("six"));
        colOne.setStyle("-fx-alignment: CENTER;");
        colTwo.setStyle("-fx-alignment: CENTER;");
        colThree.setStyle("-fx-alignment: CENTER;");
        colFour.setStyle("-fx-alignment: CENTER;");
        colFive.setStyle("-fx-alignment: CENTER;");
        colSix.setStyle("-fx-alignment: CENTER;");
        
        
        colOne2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("one"));
        colTwo2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("two"));
        colThree2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("three"));
        colFour2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("four"));
        colFive2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("five"));
        colSix2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("six"));
        colSeven2.setCellValueFactory(new PropertyValueFactory<placementList2, String>("seven"));
        colOne2.setStyle("-fx-alignment: CENTER;");
        colTwo2.setStyle("-fx-alignment: CENTER;");
        colThree2.setStyle("-fx-alignment: CENTER;");
        colFour2.setStyle("-fx-alignment: CENTER;");
        colFive2.setStyle("-fx-alignment: CENTER;");
        colSix2.setStyle("-fx-alignment: CENTER;");
        colSeven2.setStyle("-fx-alignment: CENTER;");
        

        pageOne.setVisible(true);
        pageTwo.setVisible(false);
        pageThree.setVisible(false);
        
        for(String s: matricNumbers){
            members.add(s);
        }
        pageList.setStyle("-fx-font-size: 15;");
        pageList.setItems(members);
        
        
                
        
    } 
    
    
    
    void generateRandom(ActionEvent event) {
        if (!numberField.getText().trim().equals("") && !initialField.getText().trim().equals("")) {
            Generate();
            //pageList.setItems(obList);
        }
        
        
    }
    @FXML
    void gotoPageTwo(ActionEvent event) throws IOException {     
        if (!numberField.getText().trim().equals("") && !initialField.getText().trim().equals("")) {
            Generate();
            tableOne.setItems(getComponets());
            tableTwo.setItems(getComponets2());
            
            pageOne.setVisible(false);
            pageTwo.setVisible(true);
            pageThree.setVisible(false);
        }
    }
    
    @FXML
    private void gotoPageThree(ActionEvent event) {
        
        pageOne.setVisible(false);
        pageTwo.setVisible(false);
        pageThree.setVisible(true);
//        tableTwo.setItems(getComponets2());
    }
    @FXML
    private void goBackToPageOne(){
        pageOne.setVisible(true);
        pageTwo.setVisible(false);
        pageThree.setVisible(false);
        note1.setText("");
        
        
    }
    @FXML
    private void goBackToPageTwo(){
        pageOne.setVisible(false);
        pageTwo.setVisible(true);
        pageThree.setVisible(false);
        
    }
    @FXML
    private void finishProgram(){
        System.exit(0);
        
    }
    
    void Generate(){
        initThemAll();
//        ctr = 0; ctr2 = 0; 
//        arrivalCount = 0;
//        initThemAll();
//        
//        obList.clear();
//        upper.clear();
//        clock.clear();
//        down.clear();
//        clock.clear();
//        queueAct.clear();
//        gen.clear();
        
        obList.add((float)0.071);
        clock.add((float)0);
        
        radNum = Integer.valueOf(numberField.getText().trim());
        initNum = Integer.valueOf(initialField.getText().trim());
        int c = 0;
        int temp = 0;
        float tmp = 0;
        while(c < 2*radNum){
            temp = (97 * initNum)+ 3;
            int rdr = temp % 1000;
            initNum = rdr;
            float x = rdr;
            obList.add(x/1000);
            c++;
        }
        gen.addAll(obList);
        int k = 0; int n = 0;
        for(float f : gen){
            if( k < radNum-1){
                upper.add(f);
                k++;
            }
            else{
                down.add(f);
                if(f <= 0.6){
                    queueAct.offer(cut);
                }
                else{
                    queueAct.offer(cutWash);
                }
            }
        }
        for(float re : upper){
            double dx = -3 * Math.log(re);
            float p = Float.parseFloat(String.valueOf(dx));
            tmp = tmp + p;
            tmp = Float.parseFloat(String.format("%.3f", tmp));
            clock.add(tmp);
            
        }
    }
    
    String printColTwo(int input){
       if(ctr2 < radNum-1){
           double x = -3 * Math.log(upper.get(input));         
    
           x = Double.parseDouble(String.format("%.3f", x));
           ctr2++;
           return String.valueOf(x);
        }
        else{
           return "-";
        }
    }
    
    private ObservableList<placementList> getComponets() {
        ObservableList<placementList> components = FXCollections.observableArrayList();
        for (int i = 0; i < radNum; i++) {
            components.add(new placementList( printRandOne(i),  printColTwo(i), String.valueOf(1+i),
                printClock(i), printRndTwo(i), printAct(i)));
        }
        return components;
    }
    
    
    
    
    
    String printRandOne(int v){
        if(ctr < radNum-1){ 
            ctr++;
            return String.valueOf(upper.get(v));
            
        }
        else{
            return "-" ; 
        }
        
    }
   
    
    String printClock(int input){
        Float fd = clock.get(input);
        fd = Float.parseFloat(String.format("%.3f", fd));
        return String.valueOf(fd);
    }
    
    
    String printRndTwo(int input){
        Float fd = down.get(input);
        fd = Float.parseFloat(String.format("%.3f", fd));
        return String.valueOf(fd);
    }
    String printAct(int input){
        String status;
        if(down.get(input) <= 0.6){
           status = "CUT";
        }
        else{
            status = "WASH AND CUT";
        }
        return status;
    }
    void initThemAll(){
        printCounter = 0; clk = 0; nxtEvt = 0; stA = 0; stB = 0; edA = 0; edB = 0; nothingChecker = 0; endtemp = 0; cut = 5; cutWash = 8; stopCounter = 0;
        q = 0; arrivalCount = 0;  workToDo = 0; skip = 0; tempArrival = 0;
        workerOne = false; chkQue = false; newWork = true; checkA = false; checkB = false; doNothing2 = false; doNothing = false; printNothing = false; printNothing2 = false;
        arrive = "Arr"; eos = "EndA"; printNull = "-";
        ctr = 0; ctr2 = 0; 
        arrivalCount = 0;
        obList.clear();
        upper.clear();
        clock.clear();
        down.clear();
        clock.clear();
        queueAct.clear();
        gen.clear();
    }
    
    
    
    float printCounter = 0, clk = 0, nxtEvt = 0, stA = 0, stB = 0, edA = 0, edB = 0, nothingChecker = 0, endtemp = 0, cut = 5, cutWash = 8, stopCounter = 0;
    int q = 0, arrivalCount = 0,  workToDo = 0, skip = 0, tempArrival = 0;
    boolean workerOne = false, chkQue = false, newWork = true, checkA = false, checkB = false, doNothing2 = false, doNothing = false, printNothing = false, printNothing2 = false;
    Queue<Float> queueAct = new ArrayDeque<Float>();
    String arrive = "Arr", eos = "EndA", printNull = "-";
    char next;
    
    public float timeAdder(int checkAct){
        float ret;
        if(down.get(checkAct) <= 0.6){
            ret = 5;
        }
        else{
            ret = 8;
        }
        return ret;
    }
    
    public String currentTime(){
        float clkk = 0;
        clkk = Float.parseFloat(String.format("%.3f", clk)); 
        return String.valueOf(clkk);
    }
    public String start(){
        String sta = "-";
        if(printNothing == false){
            sta = String.valueOf(Float.parseFloat(String.format("%.3f", stA)));
        }
        return sta;
    }
    public String ender(){
        String ending = "-";
        if(printNothing == false){
            ending = String.valueOf(Float.parseFloat(String.format("%.3f", edA)));
        }
        return ending;
    }
    
    public String startB(){
        String sta = "-";
        if(printNothing2 == false){
            sta = String.valueOf(Float.parseFloat(String.format("%.3f", stB)));
        }
        return sta;
    }
    public String enderB(){
        String ending = "-";
        if(printNothing2 == false){
            ending = String.valueOf(Float.parseFloat(String.format("%.3f", edB)));
        }
        return ending;
    }
    
    public String que(){
        int quu = 0;
        quu = q;
        return String.valueOf(quu);
    }
    public String nextE(){
        float nextTime = 0;
        String option = "oops";
        //nextTime = nxtEvt;
        //return String.valueOf(nextTime);
        option = optionNext();
        return option;
    }
    
    public String optionNext(){
        String strg = " ";
        int arC = arrivalCount + 1;
        float nxtEvent = Float.parseFloat(String.format("%.3f", nxtEvt));
        switch(next){
            case 'a': strg = "EOS of A at " + nxtEvent; break;
            case 'b': strg = "EOS of B at " + nxtEvent; break;
            case 'c': strg = "Arr " + arC + " at " + nxtEvent; break;
        }
        return strg;
    }
    
    private ObservableList<placementList2> getComponets2() {
        ObservableList<placementList2> components = FXCollections.observableArrayList();
        float x = 0;
        while(x < obList.size()){
            processTwo();
            components.add(new placementList2(currentTime(), start(), ender(), startB(), enderB(), que(), nextE())); 
            x++;
            if(nxtEvt == clock.get(clock.size()-1)){
                printCounter = x;
                break;
            }
        }
        
        
        return components;
        
    }
    
    public void processTwo(){
        clk = nxtEvt;
        checkA = false;
        checkB = false;
        
        if(clk >= edA && q > 0){
            skip = 0;
        }
        if(edA < clk && edB < clock.get(arrivalCount) && q == 0 && edB == clk){
            printNothing = true;
        }
        else if(edA < clk || skip == 0){
            printNothing = false;
            stA = clk;
            edA = stA + queueAct.poll();// timeAdder(arrivalCount);    
            
            
            if(q > 0){
                q--;
                checkA = false;
            }
            else{
                arrivalCount++;
            }
        }
        else if(edA > clk){
            //remain thesame
            printNothing2 = false;
            checkA = true;
            //arrivalCount++;
        }
        else{
            printNothing = true;
            checkA = false;
            //arrivalCount++; 
        }
        
        if(edA > clock.get(arrivalCount)){
            newWork = true;
        }
        else{
            newWork = false;
        }
        
        
        if(edA > clock.get(arrivalCount) || q > 0){
            if(clk < clock.get(arrivalCount)){
                if(edB > clk){
                    //remain thesame
                    //checkB = true;
                }
                else if(q > 0 && edB == clk){
                    printNothing2 = false;
                    stB = clk;                
                    edB = stB + queueAct.poll();
                    if (q > 0) {
                        q--; 
                        checkB = false;
                    } 
                    else {
                        arrivalCount++;
                    }
                }
                else{
                    printNothing2 = true;
                }
            }
            else if (edB <= clk) {
                printNothing2 = false;
                stB = clk;                
                edB = stB + queueAct.poll();
                if (q > 0) {
                    q--; 
                    checkB = false;
                } 
                else {
                    arrivalCount++;
                }
            } 
            else {
                //remain thesame
                checkB = true;
            }
        }
        else if(edB > clk){
            //remain thesame
            checkB = true;
        }
        else{
            printNothing2 = true;
        }
        if(checkA == true && checkB == true){
            q++;
            tempArrival = arrivalCount;
            checkA = false;
            checkB = false;
            arrivalCount++;
            chkQue = true;
            //System.out.println("I came here too");
            
        }
        else{
            chkQue = false;
        }
        
        if(edB != 0){
            
            
            if (printNothing == true && printNothing2 == true) {
                nxtEvt = clock.get(arrivalCount);//nxtEvt = select();
                next = 'c';
                
            } 
            else if(edA > clock.get(arrivalCount) && printNothing2 == true) {
                nxtEvt = clock.get(arrivalCount);
                next = 'c';
            }
            else if(edB > clock.get(arrivalCount) && printNothing == true) {
                nxtEvt = clock.get(arrivalCount);
                next = 'c';
            }
            else if(printNothing == true && edB < clock.get(arrivalCount) && q == 0){
                nxtEvt = edB;
                next = 'b';
            }
            else{
                nxtEvt = select();          //check out where both A and B are lesser than the new arrival
            }
        }
        else{
            
            
            if(printNothing == true && printNothing2 == true){
                nxtEvt = clock.get(arrivalCount);
                next = 'c';
                
            }
            else if(edA < clock.get(arrivalCount)){
                nxtEvt = edA;
                next = 'a';
            }
            else{
                nxtEvt = clock.get(arrivalCount);
                next = 'c';
            }
        }
        skip++;   
    }
    
    public float select(){
        float x = 0;
        if(edA < clock.get(arrivalCount) && edA < edB){
            x = edA;
            next = 'a';
        }
        else if(edB < clock.get(arrivalCount) && edB < edA){
            x = edB;
            next = 'b';
        }
        else{
            x = clock.get(arrivalCount);
            next = 'c';
        }
       
        
        return x;
    }

    
    
    public String deskTop = System.getProperty("user.home")+"/Desktop";
    @FXML
    private void printFirstPage(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter(new File(deskTop + "\\Customer's Table.txt"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("RND\t  -3ln(RND)\t  Arrival\tCLOCK\t     RND\t   Cut or wash and cut");
        bw.newLine();
        bw.newLine();
        for(int i = 0; i < radNum-1 ; i++){
            bw.write(colOne.getCellData(i)+ "\t    " + colTwo.getCellData(i)+ "\t     " +
                    colThree.getCellData(i)+ "\t\t" + colFour.getCellData(i)+ "\t     " + 
                        colFive.getCellData(i)+ "\t\t" + colSix.getCellData(i));
            bw.newLine();
        }
        bw.write(colOne.getCellData(radNum-1)+ "\t    " + colTwo.getCellData(radNum-1)+ "\t\t    " +
                    colThree.getCellData(radNum-1)+ "\t\t" + colFour.getCellData(radNum-1)+ "\t     " + 
                        colFive.getCellData(radNum-1)+ "  \t\t" + colSix.getCellData(radNum-1));
        
        bw.close();
        fw.close();
      
        note1.setText("File printed to Desktop");
    }
    
    @FXML
    private void printSecondPage(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter(new File(deskTop + "\\The Trace Table.txt"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("CLOCK\t\tSTART-A\t\tEND-A\t\tSTART-B\t\tEND-B\t    Q\t  NEXT EVENT");
        bw.newLine();
        bw.newLine();
        int i = 0;
        while(i < printCounter){
            bw.write(colOne2.getCellData(i)+ "\t\t" + colTwo2.getCellData(i)+ "\t\t" +
                    colThree2.getCellData(i)+ "\t\t" + colFour2.getCellData(i)+ "\t\t" + 
                        colFive2.getCellData(i)+ "\t    " + colSix2.getCellData(i)+ "\t  " + colSeven2.getCellData(i));
            bw.newLine();
            i++;
        }
        
        bw.close();
        fw.close();
        
        note2.setText("File printed to Desktop");
    }

    
}
