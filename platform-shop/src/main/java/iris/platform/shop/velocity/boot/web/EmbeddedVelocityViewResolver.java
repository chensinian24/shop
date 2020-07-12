package iris.platform.shop.velocity.boot.web;

import iris.platform.shop.velocity.VelocityView;
import iris.platform.shop.velocity.VelocityViewResolver;

/**
 * @author xinguiyuan
 * @date 2018-10-10 14:34:10
 * 
 */
public class EmbeddedVelocityViewResolver extends VelocityViewResolver {

	private String toolboxConfigLocation;

	@Override
	protected void initApplicationContext() {
		if (this.toolboxConfigLocation != null) {
			if (VelocityView.class.equals(getViewClass())) {
				this.logger.info("Using EmbeddedVelocityToolboxView instead of "
						+ "default VelocityView due to specified toolboxConfigLocation");
				setViewClass(EmbeddedVelocityToolboxView.class);
			}
		}
		super.initApplicationContext();
	}

	@Override
	public void setToolboxConfigLocation(String toolboxConfigLocation) {
		super.setToolboxConfigLocation(toolboxConfigLocation);
		this.toolboxConfigLocation = toolboxConfigLocation;
	}

}
