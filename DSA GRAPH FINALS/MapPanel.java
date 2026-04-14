import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

public class MapPanel extends JPanel {
    private Graph graph;
    private BarangayManager barangayManager;
    private Location customerLocation;
    private Map<String, List<DrugstoreResult>> medicineOptions;
    
    // map bounds for valenzuela
    private static final double MIN_LAT = 14.65;
    private static final double MAX_LAT = 14.75;
    private static final double MIN_LON = 120.92;
    private static final double MAX_LON = 120.98;
    
    private static final int PADDING = 40;

    public MapPanel(Graph graph, BarangayManager barangayManager) {
        this.graph = graph;
        this.barangayManager = barangayManager;
        this.medicineOptions = new HashMap<>();
        
        setBackground(new Color(240, 248, 255)); // Alice blue background
        setPreferredSize(new Dimension(700, 700));
    }

    public void setCustomerLocation(Location location) {
        this.customerLocation = location;
    }

    public void setMedicineOptions(Map<String, List<DrugstoreResult>> options) {
        this.medicineOptions = options;
    }

    public void clearMap() {
        this.customerLocation = null;
        this.medicineOptions = new HashMap<>();
        repaint();
    }

    private int latToPixelX(double latitude) {
        double normalized = (latitude - MIN_LAT) / (MAX_LAT - MIN_LAT);
        return PADDING + (int) (normalized * (getWidth() - 2 * PADDING));
    }

    private int lonToPixelY(double longitude) {
        double normalized = (MAX_LON - longitude) / (MAX_LON - MIN_LON);
        return PADDING + (int) (normalized * (getHeight() - 2 * PADDING));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        

        g2d.setColor(new Color(100, 100, 100));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(PADDING, PADDING, getWidth() - 2 * PADDING, getHeight() - 2 * PADDING);
        

        drawGrid(g2d);
        
        drawDrugstores(g2d);
        
        if (customerLocation != null) {
            drawCustomerLocation(g2d);
        }
        
        drawLegend(g2d);
    }
    
    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(new Color(200, 200, 200));
        g2d.setStroke(new BasicStroke(0.5f));
        

        for (double lat = MIN_LAT; lat <= MAX_LAT; lat += 0.025) {
            int x = latToPixelX(lat);
            g2d.drawLine(x, PADDING, x, getHeight() - PADDING);
        }
        

        for (double lon = MIN_LON; lon <= MAX_LON; lon += 0.02) {
            int y = lonToPixelY(lon);
            g2d.drawLine(PADDING, y, getWidth() - PADDING, y);
        }
    }

    private void drawDrugstores(Graphics2D g2d) {
        Map<String, Drugstore> allStores = graph.getAllDrugstores();
        
        for (Drugstore store : allStores.values()) {
            Location loc = store.getLocation();
            int x = latToPixelX(loc.getLatitude());
            int y = lonToPixelY(loc.getLongitude());

            g2d.setColor(new Color(220, 50, 50)); // red for drugstores
            g2d.fillOval(x - 8, y - 8, 16, 16);

            g2d.setColor(new Color(139, 0, 0)); 
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(x - 8, y - 8, 16, 16);

            g2d.setColor(new Color(50, 50, 50));
            g2d.setFont(new Font("Arial", Font. PLAIN, 9));
            String shortName = store.getName().substring(0, Math.min(10, store.getName().length()));
            g2d.drawString(shortName, x + 10, y);
        }
    }

    private void drawCustomerLocation(Graphics2D g2d) {
        int x = latToPixelX(customerLocation.getLatitude());
        int y = lonToPixelY(customerLocation.getLongitude());

        g2d.setColor(new Color(0, 180, 0)); 
        g2d.fillOval(x - 10, y - 10, 20, 20);

        g2d.setColor(new Color(0, 100, 0)); 
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(x - 10, y - 10, 20, 20);

        g2d.setColor(new Color(0, 100, 0));
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        g2d.drawString("YOU", x - 12, y - 15);

        drawLinesToClosestDrugstores(g2d, x, y);
    }

    private void drawLinesToClosestDrugstores(Graphics2D g2d, int customerX, int customerY) {
        Set<String> drawnStores = new HashSet<>();
        
        for (List<DrugstoreResult> options : medicineOptions.values()) {
            if (!options.isEmpty()) {
                DrugstoreResult best = options.get(0); 
                
                // find the drugstore in the graph
                for (Drugstore store : graph.getAllDrugstores().values()) {
                    if (store.getName().equals(best.getStoreName()) && !drawnStores.contains(store.getName())) {
                        Location loc = store.getLocation();
                        int storeX = latToPixelX(loc.getLatitude());
                        int storeY = lonToPixelY(loc.getLongitude());
                        
                        g2d.setColor(new Color(0, 180, 0, 100));
                        g2d.setStroke(new BasicStroke(1.5f));
                        g2d.drawLine(customerX, customerY, storeX, storeY);
                        
                        drawnStores.add(store.getName());
                        break;
                    }
                }
            }
        }
    }

    private void drawLegend(Graphics2D g2d) {
        int legendX = getWidth() - 150;
        int legendY = PADDING + 10;
        
        g2d.setColor(new Color(255, 255, 255, 200));
        g2d.fillRect(legendX - 5, legendY - 5, 140, 80);
        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 11));
        g2d.drawString("Legend", legendX, legendY + 15);
        
        g2d.setColor(new Color(220, 50, 50));
        g2d.fillOval(legendX, legendY + 25, 10, 10);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.drawString("Drugstore", legendX + 15, legendY + 32);

        g2d.setColor(new Color(0, 180, 0));
        g2d.fillOval(legendX, legendY + 45, 10, 10);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Your Location", legendX + 15, legendY + 52);
        

        g2d.setColor(new Color(0, 180, 0, 100));
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(legendX, legendY + 65, legendX + 10, legendY + 65);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Closest Store", legendX + 15, legendY + 70);
    }
}