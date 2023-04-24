package me.muawb.project.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class implements the switch is which happen do replace frame for image.
 * Contain method for set image.
 */

public class Backgrounds {

    /**
     * Anonymous class, in body override of method {@code paintComponent(Graphics)}.
     * In method set image.
     */

    private JComponent back = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            //Graphics2D must what be draw.
            Graphics2D g2 = (Graphics2D) g;
            //Determine and set image.
            Image img = new ImageIcon(this.getClass().getResource("/image/light/back.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            //This we draw.
            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    //etc.

    private JComponent back2 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning1.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back3 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning2.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h,null);
        }
    };

    private JComponent back4 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning3.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h,null);
        }
    };

    private JComponent back5 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning4.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h,null);
        }
    };

    private JComponent back6 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning5.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back7 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning6.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back8 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning7.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back9 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning8.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back10 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning9.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back11 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning10.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back12 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning11.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back13 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning12.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back14 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning13.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back15 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning14.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back16 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning15.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back17 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning16.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent back18 = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/image/light/Lightning17.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent unstart = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource(
                    "/image/backgrounds/russian/unstart.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent start = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource(
                    "/image/backgrounds/russian/start.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent preStart = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource(
                    "/image/backgrounds/russian/wr.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent postStart = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource(
                    "/image/backgrounds/russian/inter.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    private JComponent options = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource(
                    "/image/backgrounds/russian/options.png")).getImage();

            int h = getHeight();
            int w = getWidth();

            g2.drawImage(img, 0, 0, w, h, null);
        }
    };

    public JComponent getBack() {
        return back;
    }

    public JComponent getBack2() {
        return back2;
    }

    public JComponent getBack3() {
        return back3;
    }

    public JComponent getBack4() {
        return back4;
    }

    public JComponent getBack5() {
        return back5;
    }

    public JComponent getBack6() {
        return back6;
    }

    public JComponent getBack7() {
        return back7;
    }

    public JComponent getBack8() {
        return back8;
    }

    public JComponent getBack9() {
        return back9;
    }

    public JComponent getBack10() {
        return back10;
    }

    public JComponent getBack11() {
        return back11;
    }

    public JComponent getBack12() {
        return back12;
    }

    public JComponent getBack13() {
        return back13;
    }

    public JComponent getBack14() {
        return back14;
    }

    public JComponent getBack15() {
        return back15;
    }

    public JComponent getBack16() {
        return back16;
    }

    public JComponent getBack17() {
        return back17;
    }

    public JComponent getBack18() {
        return back18;
    }

    public JComponent getUnstart() {
        return unstart;
    }

    public JComponent getStart() {
        return start;
    }

    public JComponent getPreStart() {
        return preStart;
    }

    public JComponent getPostStart() {
        return postStart;
    }

    public JComponent getOptions(){
        return options;
    }
}
