 private void showCards(Object[][] houses) {
        cardsPanel.removeAll();
        if (houses.length == 0) {
            // Empty state panel
            JPanel empty = new JPanel(null) {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    // house icon
                    int cx = getWidth()/2, cy = 80;
                    g2.setColor(new Color(210, 220, 240));
                    g2.setStroke(new BasicStroke(3f));
                    int[] hx = {cx-40, cx, cx+40};
                    int[] hy = {cy, cy-32, cy};
                    g2.fillPolygon(hx, hy, 3);
                    g2.setColor(new Color(180, 195, 225));
                    g2.fillRect(cx-28, cy, 56, 36);
                    g2.setColor(new Color(210, 220, 240));
                    g2.fillRect(cx-10, cy+16, 20, 20); // door
                }
            };
            empty.setBackground(BG);
            empty.setPreferredSize(new Dimension(400, 220));
            JLabel msg = new JLabel("No properties found", SwingConstants.CENTER);
            msg.setFont(new Font("Segoe UI", Font.BOLD, 18));
            msg.setForeground(new Color(100, 120, 160));
            msg.setBounds(0, 128, 400, 28);
            empty.add(msg);
            JLabel sub = new JLabel("Try adjusting your filters or search terms", SwingConstants.CENTER);
            sub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            sub.setForeground(TEXT_GREY);
            sub.setBounds(0, 160, 400, 20);
            empty.add(sub);
            cardsPanel.add(empty);
        } else {
            for (Object[] h : houses)
                cardsPanel.add(buildCard((String)h[0], (String)h[1], (String)h[2], (int)h[3]));
        }
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
EOF
echo "done"
