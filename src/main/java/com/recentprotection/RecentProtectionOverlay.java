package com.recentprotection;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

public class RecentProtectionOverlay extends OverlayPanel
{
    private final RecentProtectionPlugin plugin;

    @Inject
    public RecentProtectionOverlay(RecentProtectionPlugin plugin)
    {
        this.plugin = plugin;
        setPosition(OverlayPosition.TOP_LEFT);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        ProtectionPrayer prayer = plugin.getLastClickedPrayer();

        if (prayer == null)
        {
            return null;
        }

        panelComponent.getChildren().add(
                LineComponent.builder()
                        .left("Last protection:")
                        .right(prayer.getDisplayName())
                        .build()
        );

        return super.render(graphics);
    }
}