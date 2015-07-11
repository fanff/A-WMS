package org.wms.view.warehouse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.wms.model.warehouse.Warehouse;

public class WarehouseView extends JPanel {

	private Warehouse warehouse;
	
	public WarehouseView(Warehouse warehouse) {
		super();
		this.warehouse = warehouse;
		initComponents();
		initUI();
	}
	
	private void initComponents() {		
		
	}
	
	private void initUI() {
		setName("WAREHOUSE STATUS");
		setLayout(new BorderLayout());
		
		JPanel warehousemap = new JPanel(new GridLayout(1,0));
		JScrollPane scrollpane = new JScrollPane(warehousemap, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollpane, BorderLayout.CENTER);
		
		warehousemap.setLayout(new GridLayout(1, warehouse.lines.size()));
		warehousemap.setSize(1000, this.getHeight());
		warehousemap.setPreferredSize(new Dimension(1000, 1000));
				
		warehouse.lines.stream()
		.forEach(line -> {
			WarehouseLineView lineView = new WarehouseLineView(line);
			warehousemap.add(lineView);
		});

	}
	
}
