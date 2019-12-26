package GUI;

import BUS.PhanCongBUS;
import DTO.PhanCongDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.Date;
import java.util.List;


public class main {
    static PhanCongBUS phanCongBUS = new PhanCongBUS();
    static JTable table = new JTable();
    static JFrame frame = new JFrame();
    static JButton btnDel = new JButton("Xóa");
    static JButton btnAdd = new JButton("Thêm");
    static JButton btnUpdate = new JButton("Sửa");
    static JScrollPane pane = new JScrollPane(table);
    static JPanel panel = new JPanel(); // button board
    static DefaultTableModel model = new DefaultTableModel();

    public static void main(String[] args) {

        //set up ui
        setUpUI();
        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"STT", "Mã lớp", "Tên môn học", "Ngày thi", "Ca thi", "Phòng thi", "Số SV", "Số CBCT", "Xếp loại"};
        model.setColumnIdentifiers(columns);
        loadData(model);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                del();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                add();
            }
        });

        // set the model to the table
        table.setModel(model);
    }

    private static void add() {
        model.addRow(new Object[]{Boolean.FALSE,null,null,null});
    }

    private static void del() {
        String phongThi;
        int caThi;
        caThi = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 4).toString());
        phongThi = model.getValueAt(table.getSelectedRow(), 5).toString();
        if(phanCongBUS.isDel(caThi, phongThi)){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            removeAllItem(model);
            loadData(model);
        }
        else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }

    }
    public static void removeAllItem(DefaultTableModel model){
        if (table.getRowCount() > 0) {
            for (int i = table.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }
    //to set up ui for app
    public static void setUpUI() {
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("", 1, 15);
        table.setFont(font);
        table.setRowHeight(20);
        frame.setLayout(new BorderLayout());
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(pane,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.SOUTH);

        // to add button to panel
        panel.add(btnAdd);
        panel.add(btnDel);
        panel.add(btnUpdate);
    }

    //load data into model
    public static void loadData(DefaultTableModel model) {
        List<PhanCongDTO> lsPhanCong = phanCongBUS.getData();
        Object[] rowData = new Object[9]; // init data rows

        for (int i = 0; i < lsPhanCong.size(); i++) {
            rowData[0] = i + 1;
            System.out.println("\t" + rowData[0]);
            rowData[1] = lsPhanCong.get(i).getMaLop();
            rowData[2] = lsPhanCong.get(i).getTenMonHoc();
            rowData[3] = lsPhanCong.get(i).getNgayThi();
            rowData[4] = lsPhanCong.get(i).getCaThi();
            rowData[5] = lsPhanCong.get(i).getPhongThi();
            rowData[6] = lsPhanCong.get(i).getSoSV();
            rowData[7] = lsPhanCong.get(i).getSoCBCT();
            if (isReach(lsPhanCong.get(i).getSoSV(), lsPhanCong.get(i).getSoCBCT())) {
                rowData[8] = "Đạt";
            } else {
                rowData[8] = "Không đạt";
            }
            model.addRow(rowData);
        }
        System.out.println("finish 1 time load");
    }

    // to check room is okay
    public static boolean isReach(int soSV, int soCBCT) {
        return soSV / 25 <= soCBCT;
    }
}
