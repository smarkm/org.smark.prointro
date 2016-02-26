package org.smark.mkp.rap.v21.webapp;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.client.service.BrowserNavigation;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class BasicEntryPoint extends AbstractEntryPoint {
	 private static final int CONTENT_MIN_HEIGHT = 800;
	  private static final int HEADER_HEIGHT = 140;
	  private static final int CENTER_AREA_WIDTH = 998;
	private Composite navBar;
	private Navigation navigation;
	private Composite mainComp;
    /**
     * @wbp.parser.entryPoint
     */
    @Override
    protected void createContents(Composite parent) {
    	parent.setLayout( new FillLayout() );
		
		ScrolledComposite scrolledComp = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComp.setExpandHorizontal(true);
		scrolledComp.setExpandVertical(true);
		
		mainComp = new Composite(scrolledComp, SWT.NONE);
		mainComp.setLayout(new FormLayout());
		
		Composite headerComp = new Composite(mainComp, SWT.NONE);
		headerComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		headerComp.setLayout(new FormLayout());
		FormData fd_headerComp = new FormData();
		fd_headerComp.right = new FormAttachment(100);
		fd_headerComp.height = 140;
		fd_headerComp.top = new FormAttachment(0);
		fd_headerComp.left = new FormAttachment(0);
		headerComp.setLayoutData(fd_headerComp);
		
		Composite contentComp = new Composite(mainComp, SWT.NONE);
		FormData fd_contentComp = new FormData();
		fd_contentComp.top = new FormAttachment(headerComp);
		fd_contentComp.right = new FormAttachment(100);
		fd_contentComp.left = new FormAttachment(headerComp, 0, SWT.LEFT);
		
		Label lblLogo = new Label(headerComp, SWT.NONE);
		lblLogo.setText("RAP");
		lblLogo.setToolTipText("");
		lblLogo.setLayoutData(new FormData());
		Image logo = getImage(headerComp.getDisplay(), "RAP-logo.png");
		lblLogo.setImage(SWTResourceManager.getImage(BasicEntryPoint.class, "/resources/RAP-logo.png"));
		lblLogo.setLayoutData(createLogoFormData(logo));
		makeLink(lblLogo, "http://www.baidu.com");
		
		Label lblNewLabel = new Label(headerComp, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(lblLogo, 0, SWT.BOTTOM);
		fd_lblNewLabel.left = new FormAttachment(lblLogo, 19);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Memo");
		  
		
		contentComp.setLayoutData(fd_contentComp);
		
		Composite navBar = new Composite(contentComp, SWT.NONE);
		navBar.setBounds(0, 0, 64, 64);
		scrolledComp.setContent(mainComp);
		scrolledComp.setMinSize(mainComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
    }
    
    public static Image getImage( Display display, String path ) {
        ClassLoader classLoader = BasicEntryPoint.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream( "resources/" + path );
        Image result = null;
        if( inputStream != null ) {
          try {
            result = new Image( display, inputStream );
          } finally {
            try {
              inputStream.close();
            } catch( IOException e ) {
              // ignore
            }
          }
        }
        return result;
      }
    private Navigation createNavigation( Composite parent ) {
        navBar = new Composite( parent, SWT.NONE );
        navBar.setLayoutData(new FormData());
        navBar.setLayout( new FormLayout() );
        navBar.setLayoutData( createNavBarFormData() );
        navBar.setData( RWT.CUSTOM_VARIANT, "nav-bar" );
        Navigation navigation = new Navigation( navBar ) {
          @Override
          protected void selectContribution( IExampleContribution contribution ) {
            BasicEntryPoint.this.selectContribution( contribution );
          }
        };
        Control navigationControl = navigation.getControl();
        navigationControl.setLayoutData( createNavigationFormData() );
        navigationControl.setData( RWT.CUSTOM_VARIANT, "navigation" );
        return navigation;
      }
    private void selectContribution( IExampleContribution contribution ) {
        navigation.selectNavigationEntry( contribution );
        activate( contribution );
      }

    private void activate( IExampleContribution contribution ) {
        IExamplePage examplePage = contribution.createPage();
        if( examplePage != null ) {
          BrowserNavigation history = RWT.getClient().getService( BrowserNavigation.class );
          if( history != null ) {
            history.pushState( contribution.getId(), contribution.getTitle() );
          }
          Control[] children = mainComp.getChildren();
          for( Control child : children ) {
            child.dispose();
          }
          Composite contentComp = ExampleUtil.initPage( contribution.getTitle(), mainComp );
          examplePage.createControl( contentComp );
          mainComp.layout( true, true );
        }
      }

	private static FormData createNavBarFormData() {
        FormData data = new FormData();
        data.top = new FormAttachment( 0 );
        data.left = new FormAttachment( 0 );
        data.right = new FormAttachment( 100 );
        return data;
      }

    private static FormData createNavigationFormData() {
        FormData data = new FormData();
        data.left = new FormAttachment( 50, ( -CENTER_AREA_WIDTH / 2 ) - 7 );
        data.top = new FormAttachment( 0 );
        data.bottom = new FormAttachment( 100 );
        data.width = CENTER_AREA_WIDTH;
        return data;
      }
    //formlayout ÷–¥π÷±æ”÷–
    private static FormData createLogoFormData( Image rapLogo ) {
        FormData data = new FormData();
        data.left = new FormAttachment( 0 );
        int logoHeight = rapLogo.getBounds().height;
        data.top = new FormAttachment( 50, -( logoHeight / 2 ) );
        return data;
      }
    
    private static void makeLink( Label control, final String url ) {
        control.setCursor( control.getDisplay().getSystemCursor( SWT.CURSOR_HAND ) );
        control.addMouseListener( new MouseAdapter() {
          @Override
          public void mouseDown( MouseEvent e ) {
            JavaScriptExecutor executor = RWT.getClient().getService( JavaScriptExecutor.class );
            if( executor != null ) {
              executor.execute( "window.location.href = '" + url + "'" );
            }
          }
        } );
      }
}
