import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jo on 17.06.2017.
 */
public class FileParser {

    private static boolean debug = true;

    /**
     * Parses the sript file and executes the commands in it.
     *
     * @param file
     * @param rob
     */
    static void parseFile(File file, Rob rob) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            ArrayList<Integer> toExecute = new ArrayList<>();
            boolean finishedLine = false;
            StringBuilder builder = new StringBuilder();


            while (reader.ready()) {
                line = reader.readLine().split(" ");

                for (int i = 0; i < line.length; i++) {
                    if (finishedLine) {
                        finishedLine = false;
                        break;
                    }
                    switch (line[i]) {
                        case "gui": {
                            toExecute.add(KeyEvent.VK_WINDOWS);
                            if (debug) {
                                System.out.println("press gui");
                            }
                            break;
                        }
                        case "enter": {
                            toExecute.add(KeyEvent.VK_ENTER);
                            if (debug) {
                                System.out.println("press enter");
                            }
                            break;
                        }
                        case "right": {
                            toExecute.add(KeyEvent.VK_RIGHT);
                            break;
                        }
                        case "up": {
                            toExecute.add(KeyEvent.VK_UP);
                            break;
                        }
                        case "left": {
                            toExecute.add(KeyEvent.VK_LEFT);
                            break;
                        }
                        case "down": {
                            toExecute.add(KeyEvent.VK_DOWN);
                            break;
                        }
                        case "shift": {
                            toExecute.add(KeyEvent.VK_SHIFT);
                            break;
                        }
                        case "tab": {
                            toExecute.add(KeyEvent.VK_TAB);
                            break;
                        }
                        case "ctrl": {
                            toExecute.add(KeyEvent.VK_CONTROL);
                            break;
                        }
                        case "alt": {
                            toExecute.add(KeyEvent.VK_ALT);
                            break;
                        }
                        case "space": {
                            toExecute.add(KeyEvent.VK_SPACE);
                            break;
                        }
                        case "esc": {
                            toExecute.add(KeyEvent.VK_ESCAPE);
                            break;
                        }
                        case "string": {
                            builder.delete(0, builder.length());
                            for (int j = 1; j < line.length; j++) {
                                builder.append(line[j]);
                                if (j + 1 != line.length) {
                                    builder.append(" ");
                                }
                            }

                            rob.typeString(builder.toString());

                            finishedLine = true;
                            if (debug) {
                                System.out.println("write " + builder.toString());
                            }
                            break;
                        }
                        case "stringN": {
                            builder.delete(0, builder.length());
                            for (int j = 1; j < line.length; j++) {
                                builder.append(line[j]);
                                if (j + 1 != line.length) {
                                    builder.append(" ");
                                }
                            }

                            rob.typeString(builder.toString());
                            rob.typeKey(KeyEvent.VK_ENTER);

                            finishedLine = true;
                            if (debug) {
                                System.out.println("write " + builder.toString());
                            }
                            break;
                        }
                        case "delay": {
                            rob.delay(Integer.valueOf(line[1]));
                            finishedLine = true;
                            if (debug) {
                                System.out.println("wait " + line[1] + " ms");
                            }
                            break;
                        }
                        default:
                            toExecute.add(KeyEvent.getExtendedKeyCodeForChar(line[i].charAt(0)));
                            if (debug) {
                                System.out.println("type " + line[i]);
                            }
                            break;
                    }
                }
                rob.executeKeyChain(toExecute);
                toExecute.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
