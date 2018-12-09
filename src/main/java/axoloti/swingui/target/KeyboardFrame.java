/**
 * Copyright (C) 2013, 2014, 2015 Johannes Taelman
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
package axoloti.swingui.target;

import axoloti.swingui.components.PianoComponent;
import axoloti.swingui.components.control.ACtrlComponent;
import axoloti.swingui.components.control.DialComponent;
import axoloti.target.TargetModel;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Johannes Taelman
 */
public class KeyboardFrame extends TJFrame {

    /**
     * Creates new form PianoFrame
     */
    private final PianoComponent piano;

    private final DialComponent pbenddial;

    private int getCable() {
        return ((SpinnerNumberModel) jSpinnerCable.getModel()).getNumber().intValue() - 1;
    }

    private byte getChannel() {
        return (byte) (((SpinnerNumberModel) jSpinnerChannel.getModel()).getNumber().intValue() - 1);
    }

    public KeyboardFrame(TargetModel targetModel) {
        super(targetModel);
        initComponents();
        piano = new PianoComponent() {
            @Override
            public void keyDown(int key) {
                try {
                    getDModel().getConnection().sendMidi(getCable(),
                            (byte) (0x90 | getChannel()),
                            (byte) (key & 0x7F),
                            (byte) jSliderVelocity.getValue()
                    );
                } catch (IOException ex) {
                    Logger.getLogger(KeyboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void keyUp(int key) {
                try {
                    getDModel().getConnection().sendMidi(getCable(),
                            (byte) (0x80 | getChannel()),
                            (byte) (key & 0x7F),
                            (byte) 80
                    );
                } catch (IOException ex) {
                    Logger.getLogger(KeyboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        Dimension d = new Dimension(910, 64);
        piano.setMinimumSize(d);
        piano.setSize(d);
        piano.setPreferredSize(d);
        piano.setMaximumSize(d);
        piano.setVisible(true);
        jPanelKeyb.add(piano);
        pbenddial = new DialComponent(0.0, -64, 64, 1);
        pbenddial.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(ACtrlComponent.PROP_VALUE)) {
                    try {
                        getDModel().getConnection().sendMidi(getCable(),
                                (byte) (0xE0 + getChannel()),
                                (byte) 0,
                                (byte) (0x07F & (int) (pbenddial.getValue() - 64.0))
                        );
                    } catch (IOException ex) {
                        Logger.getLogger(KeyboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        jPanel1.add(new JLabel("bend"));
        jPanel1.add(pbenddial);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelKeyb = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jSpinnerChannel = new javax.swing.JSpinner();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jLabel3 = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jSpinnerCable = new javax.swing.JSpinner();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jLabel2 = new javax.swing.JLabel();
        jSliderVelocity = new javax.swing.JSlider();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        jButtonAllNotesOff = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0), new java.awt.Dimension(32767, 0));

        setMinimumSize(new java.awt.Dimension(200, 60));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setName("Keyboard"); // NOI18N
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelKeyb.setAlignmentX(0.0F);
        jPanelKeyb.setAlignmentY(0.0F);
        jPanelKeyb.setMaximumSize(new java.awt.Dimension(905, 64));
        jPanelKeyb.setMinimumSize(new java.awt.Dimension(905, 64));
        jPanelKeyb.setPreferredSize(new java.awt.Dimension(905, 64));
        jPanelKeyb.setLayout(new javax.swing.BoxLayout(jPanelKeyb, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanelKeyb);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 51));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Midi Channel");
        jPanel1.add(jLabel1);
        jPanel1.add(filler1);

        jSpinnerChannel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 16, 1));
        jSpinnerChannel.setMaximumSize(null);
        jSpinnerChannel.setMinimumSize(null);
        jSpinnerChannel.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(jSpinnerChannel);
        jPanel1.add(filler2);

        jLabel3.setText("Cable");
        jPanel1.add(jLabel3);
        jPanel1.add(filler5);

        jSpinnerCable.setModel(new javax.swing.SpinnerNumberModel(1, 1, 16, 1));
        jSpinnerCable.setMaximumSize(null);
        jSpinnerCable.setMinimumSize(null);
        jSpinnerCable.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(jSpinnerCable);
        jPanel1.add(filler6);

        jLabel2.setText("Velocity");
        jPanel1.add(jLabel2);

        jSliderVelocity.setMajorTickSpacing(32);
        jSliderVelocity.setMaximum(127);
        jSliderVelocity.setMinimum(1);
        jSliderVelocity.setPaintTicks(true);
        jSliderVelocity.setValue(80);
        jSliderVelocity.setMinimumSize(new java.awt.Dimension(64, 31));
        jPanel1.add(jSliderVelocity);
        jPanel1.add(filler4);

        jButtonAllNotesOff.setText("All Notes Off");
        jButtonAllNotesOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllNotesOffActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAllNotesOff);
        jPanel1.add(filler3);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAllNotesOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllNotesOffActionPerformed
        try {
            getDModel().getConnection().sendMidi(getCable(), 
                    (byte) (0xB0 + getChannel()),
                    (byte) 0x7B,
                    (byte) 80
            );
            piano.clear();
        } catch (IOException ex) {
            Logger.getLogger(KeyboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAllNotesOffActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JButton jButtonAllNotesOff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelKeyb;
    private javax.swing.JSlider jSliderVelocity;
    private javax.swing.JSpinner jSpinnerCable;
    private javax.swing.JSpinner jSpinnerChannel;
    // End of variables declaration//GEN-END:variables


    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        if (TargetModel.CONNECTION.is(evt)) {
            piano.clear();
            boolean b = evt.getNewValue() != null;
            piano.setEnabled(b);
            pbenddial.setEnabled(b);
            jButtonAllNotesOff.setEnabled(b);
        }
    }

}
