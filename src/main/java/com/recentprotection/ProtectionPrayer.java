package com.recentprotection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProtectionPrayer
{
    MAGIC("Protect from Magic", "Magic"),
    RANGED("Protect from Missiles", "Ranged"),
    MELEE("Protect from Melee", "Melee");

    private final String menuName;
    private final String displayName;

    public static ProtectionPrayer fromMenuTarget(String target)
    {
        for (ProtectionPrayer prayer : values())
        {
            if (target.equalsIgnoreCase(prayer.menuName))
            {
                return prayer;
            }
        }

        return null;
    }
}