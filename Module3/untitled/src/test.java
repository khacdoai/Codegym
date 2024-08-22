import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class test extends JFrame {

        private static final long serialVersionUID = 1L;
        private JSpinner spinnerSoTienRut, spinnerSoTienGui;
        private int giaTriRut, giaTriGui;

        public void Cua_so_tanggiam() {
            setTitle("Giao Diện Java");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            setLayout(new BorderLayout());

            JPanel SoTienRut = new JPanel(new FlowLayout(FlowLayout.LEFT));
            SoTienRut.add(new JLabel("Số Tiền Muốn Rút:"));
            spinnerSoTienRut = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 50));
            SoTienRut.add(spinnerSoTienRut);

            JPanel SoTienGui = new JPanel(new FlowLayout(FlowLayout.LEFT));
            SoTienGui.add(new JLabel("Số Tiền Gửi Vào:"));
            spinnerSoTienGui = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 50));
            SoTienGui.add(spinnerSoTienGui);

            add(SoTienRut, BorderLayout.NORTH);
            add(SoTienGui, BorderLayout.CENTER);

            JPanel Button = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton tangButton = new JButton("Tăng");
            tangButton.setForeground(Color.red);
            tangButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tangGiaTri();
                }
            });
            Button.add(tangButton);

            JButton giamButton = new JButton("Giảm");
            giamButton.setForeground(Color.red);
            giamButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    giamGiaTri();
                }
            });
            Button.add(giamButton);

            JButton chuyenButton = new JButton("Lịch sử");
            chuyenButton.setForeground(Color.red);
            chuyenButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    chuyenGiaoDien();
                }
            });
            Button.add(chuyenButton);

            add(Button, BorderLayout.SOUTH);
        }

        private void tangGiaTri() {
            giaTriRut = (int) spinnerSoTienRut.getValue();
            giaTriGui = (int) spinnerSoTienGui.getValue();

            spinnerSoTienRut.setValue(giaTriRut + 50);
            spinnerSoTienGui.setValue(giaTriGui + 50);
        }

        private void giamGiaTri() {
            giaTriRut = (int) spinnerSoTienRut.getValue();
            giaTriGui = (int) spinnerSoTienGui.getValue();

            spinnerSoTienRut.setValue(giaTriRut - 50 >= 0 ? giaTriRut - 50 : 0);
            spinnerSoTienGui.setValue(giaTriGui - 50 >= 0 ? giaTriGui - 50 : 0);
        }

        private void chuyenGiaoDien() {
            Cua_so_lichsu fiveFrame = new Cua_so_lichsu();
            fiveFrame.setVisible(true);
            this.dispose();
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Cua_so_tanggiam sixFrame = new Cua_so_tanggiam();
                    sixFrame.setVisible(true);
                }
            });
        }
    }
