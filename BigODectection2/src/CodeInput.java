import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author Yash Jain
 *         Determine Big O;
 */
public class CodeInput {

    protected Shell shell;
    private Text codeUser;
    protected String code;
    private int userBigO;
    private int comptuerBigO;
    protected int question1;
    private Table table;
    private TableItem item;


    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            CodeInput window = new CodeInput();
            window.open();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }


    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(1000, 500);
        shell.setText("Big O Efficiency Learning Program");

        codeUser = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP
            | SWT.V_SCROLL);

        codeUser.setBounds(65, 119, 365, 176);

        Label lblTypeYourCode = new Label(shell, SWT.NONE);
        lblTypeYourCode.setFont(SWTResourceManager.getFont("Segoe UI", 10,
            SWT.NORMAL));
        lblTypeYourCode.setBounds(10, 92, 200, 21);
        lblTypeYourCode.setText("Type your Code Below:");

        Label problemChoice = new Label(shell, SWT.NONE);
        problemChoice.setBounds(10, 10, 464, 76);
        problemChoice.setText(
            "Choose which question you would like from the choices below.");
        Label lblYourBigO = new Label(shell, SWT.NONE);
        lblYourBigO.setFont(SWTResourceManager.getFont("Segoe UI", 11,
            SWT.BOLD));
        lblYourBigO.setBounds(20, 339, 115, 26);
        lblYourBigO.setText("Your Big O is:");

        Label lblWhatMostEfficient = new Label(shell, SWT.NONE);
        lblWhatMostEfficient.setText("What Most Efficient Big O Is:");
        lblWhatMostEfficient.setFont(SWTResourceManager.getFont("Segoe UI", 11,
            SWT.BOLD));
        lblWhatMostEfficient.setBounds(20, 378, 250, 26);

        Label userBigOValue = new Label(shell, SWT.NONE);
        userBigOValue.setFont(SWTResourceManager.getFont("Segoe UI", 11,
            SWT.BOLD));
        userBigOValue.setBounds(141, 339, 69, 21);
        userBigOValue.setText("");

        Label actualBigO = new Label(shell, SWT.NONE);
        actualBigO.setFont(SWTResourceManager.getFont("Segoe UI", 11,
            SWT.BOLD));
        actualBigO.setBounds(276, 378, 69, 21);
        actualBigO.setText("");

        Label percentage = new Label(shell, SWT.NONE);
        percentage.setAlignment(SWT.CENTER);
        percentage.setFont(SWTResourceManager.getFont("Segoe UI", 15,
            SWT.BOLD));
        percentage.setBounds(716, 351, 258, 46);

        Button btnDone = new Button(shell, SWT.NONE);
        btnDone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                code = codeUser.getText();
                userBigO = parseValue(code);
                if (question1 == 1) {
                    comptuerBigO = 1;
                    actualBigO.setText("n");
                }
                if (question1 == 2) {
                    comptuerBigO = 2;
                    actualBigO.setText("n^" + comptuerBigO);
                }
                if (question1 == 3) {
                    comptuerBigO = 3;
                    actualBigO.setText("" + 1);
                }
                if (userBigO == 0) {

                }
                else if (userBigO == 1) {
                    userBigOValue.setText("n");
                }
                else {
                    userBigOValue.setText("n^" + userBigO);
                }

            }
        });
        btnDone.setBounds(366, 301, 108, 26);
        btnDone.setText(" Done!");

        Button questionOne = new Button(shell, SWT.NONE);
        questionOne.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 1;
                problemChoice.setText(
                    "Return an array that contains the exact same numbers as the given\narray, but rearranged so"
                        + " that all the even numbers come before all the odd numbers. Other than that, the numbers "
                        + "can be in any order. You may modify and return the\ngiven array, or make a new array. [0,1,2,3]");
            }
        });
        questionOne.setBounds(10, 301, 85, 26);
        questionOne.setText("Question 1");

        Button questionTwo = new Button(shell, SWT.NONE);
        questionTwo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 2;
                problemChoice.setText(
                    "Given a string, return the longest substring that appears at both the "
                        + "\nbeginning and end of the string without overlapping."
                        + "\nFor example, sameEnds(\"abXab\") is \"ab\". "
                        + "sameEnds(\"abXYab\") -->\"ab\"");
            }
        });
        questionTwo.setBounds(101, 301, 85, 26);
        questionTwo.setText("Question 2");

        Button questionThree = new Button(shell, SWT.NONE);
        questionThree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                question1 = 3;
                problemChoice.setText(
                    "Given 2 int arrays, a and b, of any length, return a new array\n"
                        + "with the first element of each array. If either array is length 0, ignore\n"
                        + "that array. front11([1, 2, 3], [7, 9, 8]) -> [1, 7]");
            }
        });
        questionThree.setBounds(192, 301, 85, 26);
        questionThree.setText("Question 3");

        Button analysisData = new Button(shell, SWT.NONE);

        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(490, 63, 482, 254);

        analysisData.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                Rectangle bounds = table.getBounds();
                table.redraw(bounds.x, bounds.y, bounds.width, bounds.height,
                    true);
                table.removeAll();
                table.setHeaderVisible(true);
                table.setLinesVisible(true);

                TableColumn tblclmnTerms = new TableColumn(table, SWT.NONE);
                tblclmnTerms.setResizable(false);
                tblclmnTerms.setMoveable(true);
                tblclmnTerms.setWidth(120);
                tblclmnTerms.setText("Terms");

                TableColumn tblclmnCost = new TableColumn(table, SWT.NONE);
                tblclmnCost.setResizable(false);
                tblclmnCost.setMoveable(true);
                tblclmnCost.setWidth(120);
                tblclmnCost.setText("Your Efficiency");

                TableColumn tblclmnUser = new TableColumn(table, SWT.NONE);
                tblclmnUser.setResizable(false);
                tblclmnUser.setMoveable(true);
                tblclmnUser.setWidth(120);
                tblclmnUser.setText("Cost for: " + userBigOValue.getText());

                TableColumn tblclmnActual = new TableColumn(table, SWT.NONE);
                tblclmnActual.setResizable(false);
                tblclmnActual.setMoveable(true);
                tblclmnActual.setWidth(120);
                tblclmnActual.setText("Cost for: " + actualBigO.getText());

                int counter = 1;
                double costPerTerm = .05;
                double percentageExcess = 0;
                while (counter < 1100) {
                    item = new TableItem(table, SWT.NONE);
                    double computerEff = 1;
                    double yourEff = (int)Math.pow(counter, userBigO);
                    if (comptuerBigO == 3) {
                        item.setText(0, "" + counter);
                        item.setText(1, "" + Math.ceil(yourEff));
                        item.setText(2, "$" + Math.ceil(yourEff * costPerTerm));
                        item.setText(3, "$" + .05);
                    }
                    else {
                        computerEff = (int)Math.pow(counter, comptuerBigO);

                        item.setText(0, "" + counter);
                        item.setText(1, "" + Math.ceil(yourEff));
                        item.setText(2, "$" + Math.ceil(yourEff * costPerTerm));
                        item.setText(3, "$" + Math.ceil(computerEff
                            * costPerTerm));
                    }
                    percentageExcess = (double)((yourEff * costPerTerm)
                        / (computerEff * costPerTerm));
                    counter = counter + 100;
                }

                if (percentageExcess == 1) {

                    percentage.setText("" + 0 + "%");
                }
                else {

                    percentage.setText("" + percentageExcess + "%");
                }
            }
        });
        analysisData.setFont(SWTResourceManager.getFont("Segoe UI", 12,
            SWT.BOLD));
        analysisData.setBounds(644, 10, 190, 36);
        analysisData.setText("Efficiency Analysis");

        Label lblCostPerTerm = new Label(shell, SWT.NONE);
        lblCostPerTerm.setAlignment(SWT.CENTER);
        lblCostPerTerm.setBounds(840, 19, 134, 36);
        lblCostPerTerm.setText("Cost Per Term: $.05");

        Label Precentage = new Label(shell, SWT.NONE);
        Precentage.setFont(SWTResourceManager.getFont("Segoe UI", 13,
            SWT.BOLD));
        Precentage.setAlignment(SWT.CENTER);
        Precentage.setBounds(534, 339, 217, 65);
        Precentage.setText("Extra Cost Percentage:  ");

    }


    /**
     * @param textUser
     *            This is the text that is being read for the number of times
     *            that has for or while
     * @return int
     *         This is the bigO value just based on the the for/while loops
     */
    public static int parseValue(String textUser) {
        int count = 0;
        textUser = textUser.toLowerCase();

        String tempDecreaseFor = textUser;
        int index = textUser.indexOf("for(");
        while (index != -1) {
            count++;
            tempDecreaseFor = tempDecreaseFor.substring(index + 1);
            index = tempDecreaseFor.indexOf("for(");
        }

        String tempDecreaseFor2 = textUser;
        int index2 = textUser.indexOf("for ");
        while (index2 != -1) {
            count++;
            tempDecreaseFor2 = tempDecreaseFor2.substring(index2 + 1);
            index2 = tempDecreaseFor2.indexOf("for ");
        }

        String tempDecreaseWhile = textUser;
        int index3 = textUser.indexOf("while(");
        while (index3 != -1) {
            count++;
            tempDecreaseWhile = tempDecreaseWhile.substring(index3 + 1);
            index3 = tempDecreaseWhile.indexOf("while(");
        }

        String tempDecreaseWhile2 = textUser;
        int index4 = textUser.indexOf("while ");
        while (index4 != -1) {
            count++;
            tempDecreaseWhile2 = tempDecreaseWhile2.substring(index4 + 1);
            index4 = tempDecreaseWhile2.indexOf("while ");
        }

        return count;

    }
}
