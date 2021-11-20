package com.drpicox.game.testSteps.owneds;

import com.drpicox.game.testSteps.game.entities.EntityResponse;
import com.drpicox.game.testSteps.game.entities.EntityTestView;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class OwnedTestView {

    private final EntityTestView entityTestView;

    public OwnedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public static Predicate<EntityResponse> byOwner(String ownerName) {
        return e -> e.getOrDefault("owner", "").equals(ownerName);
    }

    public static Function<EntityResponse,String> toOwner() {
        return e -> (String) e.getOrDefault("owner", "-without owner-");
    }

    public String getOnwer() {
        return getOnwer(entityTestView.getEntityId());
    }

    public String getOnwer(String entityId) {
        return entityTestView.getEntityPropertyString(entityId, "owner");
    }
}
