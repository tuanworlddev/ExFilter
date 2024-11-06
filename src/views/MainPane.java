package views;

import service.CSVService;
import service.ExcelService;
import service.FileService;
import service.PropertiesService;
import utils.Constraints;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPane {
    private JPanel contentPane;
    private JButton import1Btn;
    private JButton delete1Btn;
    private JTextField textField1;
    private JButton excel1Button;
    private JTextArea codeTextArea;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField excel1Field;
    private JTextField excel2Field;
    private JButton excel2Button;
    private JButton import2Btn;
    private JButton import3Btn;
    private JButton import4Btn;
    private JButton import5Btn;
    private JButton import6Btn;
    private JButton import7Btn;
    private JButton import8Btn;
    private JButton import9Btn;
    private JButton import10Btn;
    private JButton delete2Btn;
    private JButton delete3Btn;
    private JButton delete4Btn;
    private JButton delete5Btn;
    private JButton delete6Btn;
    private JButton delete7Btn;
    private JButton delete8Btn;
    private JButton delete9Btn;
    private JButton delete10Btn;
    private JButton exportButton;

    private final List<String> list1;
    private final List<String> list2;
    private final List<String> list3;
    private final List<String> list4;
    private final List<String> list5;
    private final List<String> list6;
    private final List<String> list7;
    private final List<String> list8;
    private final List<String> list9;
    private final List<String> list10;


    private JFileChooser fileChooser;
    private JFileChooser excelFileChooser;

    public MainPane() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        list7 = new ArrayList<>();
        list8 = new ArrayList<>();
        list9 = new ArrayList<>();
        list10 = new ArrayList<>();

        initConstraint();
        initAction();
        loadData();
    }

    private void loadData() {
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA1_FILEPATH), list1, textField1, 1);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA2_FILEPATH), list2, textField2, 2);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA3_FILEPATH), list3, textField3, 3);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA4_FILEPATH), list4, textField4, 4);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA5_FILEPATH), list5, textField5, 5);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA6_FILEPATH), list6, textField6, 6);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA7_FILEPATH), list7, textField7, 7);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA8_FILEPATH), list8, textField8, 8);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA9_FILEPATH), list9, textField9, 9);
        uploadList(PropertiesService.getInstance().getProperty(Constraints.DATA10_FILEPATH), list10, textField10, 10);
    }

    private void uploadList(String filePath, List<String> list, JTextField textField, int id) {
        try {
            List<String> tempList = CSVService.readCSV(filePath);
            list.clear();
            list.addAll(tempList);
            textField.setText("(" + id + ") Size: " + list.size());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    private void initConstraint() {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

        excelFileChooser = new JFileChooser();
        excelFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        excelFileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xls", "xlsx"));
    }

    private void initAction() {

        assert import1Btn != null;
        import1Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA1_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list1, textField1, 1);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import2Btn != null;
        import2Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA2_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list2, textField2, 2);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import3Btn != null;
        import3Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA3_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list3, textField3, 3);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import4Btn != null;
        import4Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA4_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list4, textField4, 4);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import5Btn != null;
        import5Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA5_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list5, textField5, 5);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import6Btn != null;
        import6Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA6_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list6, textField6, 6);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import7Btn != null;
        import7Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA7_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list7, textField7, 7);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import8Btn != null;
        import8Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA8_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list8, textField8, 8);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import9Btn != null;
        import9Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA9_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list9, textField9, 9);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        assert import10Btn != null;
        import10Btn.addActionListener(e -> {
            fileChooser.showOpenDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    try {
                        List<String> csvData = CSVService.readCSV(fileChooser.getSelectedFile().getAbsolutePath());
                        if (!csvData.isEmpty()) {
                            csvData.removeFirst();
                        }
                        String fileCSV = PropertiesService.getInstance().getProperty(Constraints.DATA10_FILEPATH);
                        FileService.writeCSVFile(fileCSV, csvData, true);
                        uploadList(fileCSV, list10, textField10, 10);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }).start();
            }
        });

        delete1Btn.addActionListener(e -> {
            list1.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA1_FILEPATH));
            textField1.setText("(1) Size: 0");
        });

        delete2Btn.addActionListener(e -> {
            list2.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA2_FILEPATH));
            textField2.setText("(2) Size: 0");
        });

        delete3Btn.addActionListener(e -> {
            list3.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA3_FILEPATH));
            textField3.setText("(3) Size: 0");
        });

        delete4Btn.addActionListener(e -> {
            list4.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA4_FILEPATH));
            textField4.setText("(4) Size: 0");
        });

        delete5Btn.addActionListener(e -> {
            list5.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA5_FILEPATH));
            textField5.setText("(5) Size: 0");
        });

        delete6Btn.addActionListener(e -> {
            list6.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA6_FILEPATH));
            textField6.setText("(6) Size: 0");
        });

        delete7Btn.addActionListener(e -> {
            list7.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA7_FILEPATH));
            textField7.setText("(7) Size: 0");
        });

        delete8Btn.addActionListener(e -> {
            list8.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA8_FILEPATH));
            textField8.setText("(8) Size: 0");
        });

        delete9Btn.addActionListener(e -> {
            list9.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA9_FILEPATH));
            textField9.setText("(9) Size: 0");
        });

        delete10Btn.addActionListener(e -> {
            list10.clear();
            FileService.deleteFile(PropertiesService.getInstance().getProperty(Constraints.DATA10_FILEPATH));
            textField10.setText("(10) Size: 0");
        });

        excel1Button.addActionListener(e -> {
            excelFileChooser.showOpenDialog(contentPane);
            if (excelFileChooser.getSelectedFile() != null) {
                excel1Field.setText(excelFileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        excel2Button.addActionListener(e -> {
            excelFileChooser.showOpenDialog(contentPane);
            if (excelFileChooser.getSelectedFile() != null) {
                excel2Field.setText(excelFileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        exportButton.addActionListener(e -> {
            if (excel1Field.getText().isBlank() || excel2Field.getText().isBlank()) {
                JOptionPane.showMessageDialog(contentPane, "Please input all the fields to be exported.");
                return;
            }
            List<String> qrCode = new ArrayList<>();
            if (!codeTextArea.getText().isBlank()) {
                Pattern pattern = Pattern.compile("(\\d+):(\\d+)-(\\d+)");
                String[] commands = codeTextArea.getText().split("\n");
                for (String command : commands) {
                    Matcher matcher = pattern.matcher(command);

                    if (matcher.matches()) {
                        int id = Integer.parseInt(matcher.group(1));
                        int from = Integer.parseInt(matcher.group(2));
                        int to = Integer.parseInt(matcher.group(3));
                        if (!getQRCode(id, to - from + 1, qrCode)) {
                            return;
                        }
                    }
                }
            }

            fileChooser.showSaveDialog(contentPane);
            if (fileChooser.getSelectedFile() != null) {
                new Thread(() -> {
                    export1(fileChooser.getSelectedFile().getAbsolutePath(), excel1Field.getText(), excel2Field.getText(), qrCode);
                }).start();
                new Thread(() -> {
                    export2(fileChooser.getSelectedFile().getAbsolutePath(), excel2Field.getText(), qrCode);
                }).start();
            }
        });
    }

    private void export1(String filePath, String excel1, String excel2, List<String> qrCode) {
        try {
            Object[][] excel1Data = ExcelService.readExcel(excel1);
            Object[][] excel2Data = ExcelService.readExcel(excel2);

            Object[][] data = new Object[excel2Data.length + 1][10];
            data[0] = new Object[]{"Стикер № 1", "Стикер № 2", "QR-Код", "Артикул-цвет", "Размер", "Баркод", "Бренд", "Продавец", "QR-Ч-Знак", "Предмет"};

            Map<String, Object[]> map1 = new HashMap<>();
            for (Object[] excel1Datum : excel1Data) {
                String key = ((String) excel1Datum[13]).replaceAll("\\s+", "");
                map1.put(key, excel1Datum);
                System.out.println(key);
            }

            for (int i = 0; i < excel2Data.length; i++) {
                for (int j = 0; j < 10; j++) {
                    String sticker = ((String) excel2Data[i][8]).replaceAll("\\s+", "");
                    System.out.println(sticker);
                    if (map1.containsKey(sticker)) {
                        Object[] data1 = map1.get(sticker);
                        String[] stickers = sticker.split(" ");
                        String[] designations = excel2Data[i][4].toString().split(" ");

                        String cell0Value = stickers.length > 0 ? stickers[0] : "";
                        String cell1Value = stickers.length > 1 ? stickers[1] : "";
                        String cell2Value = data1[14] != null ? (String) data1[14] : "";
                        String cell3Value = excel2Data[i][7] != null ? (String) excel2Data[i][7] : "";
                        String cell4Value = excel2Data[i][5] != null ? (String) excel2Data[i][5] : "";
                        String cell5Value = excel2Data[i][9] != null ? (String) excel2Data[i][9] : "";
                        String cell6Value = excel2Data[i][3] != null ? (String) excel2Data[i][3] : "";
                        String cell7Value = "ИП ДИНЬ ТХИ МАЙ";
                        String cell8Value = i < qrCode.size() ? qrCode.get(i) : "";
                        String cell9Value = designations.length >= 2 ? designations[0] + " " + designations[1] : designations[0];
                        data[i + 1] = new Object[]{
                                cell0Value, cell1Value, cell2Value, cell3Value, cell4Value, cell5Value, cell6Value, cell7Value, cell8Value, cell9Value
                        };
                    }
                }
            }

            CSVService.writeCSV(filePath, data);
            Desktop.getDesktop().open(new File(filePath));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(contentPane, "Could not export 1\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void export2(String filePath, String excel2, List<String> qrCode) {
        try {
            Object[][] excel2Data = ExcelService.readExcel(excel2);
            Object[][] data = new Object[excel2Data.length + 1][3];
            data[0] = new Object[]{"№ задания", "Стикер", "КИЗ"};

            for (int i = 0; i < excel2Data.length; i++) {
                String cell0 = (String) excel2Data[i][1];
                String cell1 = excel2Data[i][8].toString().replace(" ", "");
                String qr = i < qrCode.size() ? qrCode.get(i) : "";
                String cell2 = qr.length() > 32 ? qr.substring(0, 32) : qr;
                data[i + 1] = new Object[]{cell0, cell1, cell2};
            }
            int lastDotIndex = filePath.lastIndexOf(".");
            String fileNameWithoutExtension = (lastDotIndex != -1) ? filePath.substring(0, lastDotIndex) : filePath;
            String fileExtension = (lastDotIndex != -1) ? filePath.substring(lastDotIndex) : ".xlsx";

            String newFileName = fileNameWithoutExtension + "_1" + fileExtension;

            CSVService.writeCSV(newFileName, data);
            Desktop.getDesktop().open(new File(newFileName));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Could not export 2\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    private boolean getQRCode(int id, int count, List<String> qrCodelist) {
        switch (id) {
            case 1 -> {
                if (count <= list1.size()) {
                    qrCodelist.addAll(list1.subList(0, count));
                    list1.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA1_FILEPATH), list1, false);
                    textField1.setText("(" + id + ") Size: " + list1.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 2 -> {
                if (count <= list2.size()) {
                    qrCodelist.addAll(list2.subList(0, count));
                    list2.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA2_FILEPATH), list2, false);
                    textField2.setText("(" + id + ") Size: " + list2.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 3 -> {
                if (count <= list3.size()) {
                    qrCodelist.addAll(list3.subList(0, count));
                    list3.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA3_FILEPATH), list3, false);
                    textField3.setText("(" + id + ") Size: " + list3.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 4 -> {
                if (count <= list4.size()) {
                    qrCodelist.addAll(list4.subList(0, count));
                    list4.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA4_FILEPATH), list4, false);
                    textField4.setText("(" + id + ") Size: " + list4.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 5 -> {
                if (count <= list5.size()) {
                    qrCodelist.addAll(list5.subList(0, count));
                    list5.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA5_FILEPATH), list5, false);
                    textField5.setText("(" + id + ") Size: " + list5.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 6 -> {
                if (count <= list6.size()) {
                    qrCodelist.addAll(list6.subList(0, count));
                    list6.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA6_FILEPATH), list6, false);
                    textField6.setText("(" + id + ") Size: " + list6.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 7 -> {
                if (count <= list7.size()) {
                    qrCodelist.addAll(list7.subList(0, count));
                    list7.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA7_FILEPATH), list7, false);
                    textField7.setText("(" + id + ") Size: " + list7.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 8 -> {
                if (count <= list8.size()) {
                    qrCodelist.addAll(list8.subList(0, count));
                    list8.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA8_FILEPATH), list8, false);
                    textField8.setText("(" + id + ") Size: " + list8.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 9 -> {
                if (count <= list9.size()) {
                    qrCodelist.addAll(list9.subList(0, count));
                    list9.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA9_FILEPATH), list9, false);
                    textField9.setText("(" + id + ") Size: " + list9.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            case 10 -> {
                if (count <= list10.size()) {
                    qrCodelist.addAll(list10.subList(0, count));
                    list10.subList(0, count).clear();
                    FileService.writeCSVFile(PropertiesService.getInstance().getProperty(Constraints.DATA10_FILEPATH), list10, false);
                    textField10.setText("(" + id + ") Size: " + list10.size());
                } else {
                    JOptionPane.showMessageDialog(contentPane, "The size of the list is too large with id = " + id + ".");
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    public JPanel getContentPane() {
        return contentPane;
    }


}
