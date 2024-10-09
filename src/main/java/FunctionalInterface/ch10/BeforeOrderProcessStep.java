package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Order;

abstract class BeforeOrderProcessStep {
    private BeforeOrderProcessStep nextStep;

    public BeforeOrderProcessStep setNext(BeforeOrderProcessStep nextStep) {
        if (this.nextStep == null) {
            this.nextStep = nextStep;
        } else {
            this.nextStep.setNext(nextStep);
        }
        return this;
    }

    public void process(Order order) {
        processOrder(order);
        if (nextStep != null) {
            nextStep.process(order);
        }
    }

    protected abstract void processOrder(Order order);
}
