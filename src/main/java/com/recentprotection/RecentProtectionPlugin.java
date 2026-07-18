package com.recentprotection;

import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.util.Text;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Recent Protection Prayer",
		description = "Displays the most recently clicked protection prayer",
		tags = {"prayer", "protection", "combat"}
)
public class RecentProtectionPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RecentProtectionOverlay overlay;

	@Getter
	private ProtectionPrayer lastClickedPrayer;

	@Override
	protected void startUp()
	{
		lastClickedPrayer = null;
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		lastClickedPrayer = null;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		String target = Text.removeTags(event.getMenuTarget()).trim();

		ProtectionPrayer clickedPrayer =
				ProtectionPrayer.fromMenuTarget(target);

		if (clickedPrayer != null)
		{
			lastClickedPrayer = clickedPrayer;
		}
	}
}