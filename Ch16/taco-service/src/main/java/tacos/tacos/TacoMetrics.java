package tacos.tacos;

import java.util.List;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;

@Component
public class TacoMetrics extends AbstractRepositoryEventListener<Taco> {

  private MeterRegistry meterRegistry;

  public TacoMetrics(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }

  @Override
  protected void onBeforeCreate(Taco entity) {
    System.out.println("onBeforeCreate!!!");
    super.onBeforeCreate(entity);
  }

  @Override
  protected void onBeforeSave(Taco entity) {
    System.out.println("onBeforeSave!!!");
    super.onBeforeSave(entity);
  }

  @Override
  protected void onAfterSave(Taco entity) {
    System.out.println("onAfterSave!!!");
    super.onAfterSave(entity);
  }

  @Override
  protected void onBeforeLinkSave(Taco parent, Object linked) {
    System.out.println("onBeforeLinkSave!!!");
    super.onBeforeLinkSave(parent, linked);
  }

  @Override
  protected void onAfterLinkSave(Taco parent, Object linked) {
    System.out.println("onAfterLinkSave!!!");
    super.onAfterLinkSave(parent, linked);
  }

  @Override
  protected void onBeforeLinkDelete(Taco parent, Object linked) {
    System.out.println("onBeforeLinkDelete!!!");
    super.onBeforeLinkDelete(parent, linked);
  }

  @Override
  protected void onAfterLinkDelete(Taco parent, Object linked) {
    System.out.println("onAfterLinkDelete!!!");
    super.onAfterLinkDelete(parent, linked);
  }

  @Override
  protected void onBeforeDelete(Taco entity) {
    System.out.println("onBeforeDelete!!!");
    super.onBeforeDelete(entity);
  }

  @Override
  protected void onAfterDelete(Taco entity) {
    System.out.println("onAfterDelete!!!");
    super.onAfterDelete(entity);
  }

  @Override
  protected void onAfterCreate(Taco taco) {
    System.out.println("onAfterCreate!!!");
    List<Ingredient> ingredients = taco.getIngredients();
    for (Ingredient ingredient : ingredients) {
      meterRegistry.counter("tacocloud", 
          "ingredient", ingredient.getId()).increment();
    }
  }

}
