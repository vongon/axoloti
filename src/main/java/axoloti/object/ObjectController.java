package axoloti.object;

import axoloti.mvc.AbstractController;
import axoloti.mvc.IView;
import axoloti.object.inlet.Inlet;
import axoloti.object.outlet.Outlet;
import axoloti.object.parameter.Parameter;

/**
 *
 * @author jtaelman
 */
public class ObjectController extends AbstractController<IAxoObject, IView, AbstractController> {

    public ObjectController(IAxoObject model) {
        // TODO: remove public constructor
        super(model);
    }

    public void addParameter(Parameter parameter) {
        parameter.setParent((AxoObject) getModel());
        addUndoableElementToList(AxoObject.OBJ_PARAMETERS, parameter);
    }

    public void removeParameter(Parameter parameter) {
        removeUndoableElementFromList(AxoObject.OBJ_PARAMETERS, parameter);
    }

    public void addInlet(Inlet inlet) {
        inlet.setParent((AxoObject) getModel());
        addUndoableElementToList(AxoObject.OBJ_INLETS, inlet);
    }

    public void removeInlet(Inlet inlet) {
        removeUndoableElementFromList(AxoObject.OBJ_INLETS, inlet);
    }

    public void addOutlet(Outlet outlet) {
        outlet.setParent((AxoObject) getModel());
        addUndoableElementToList(AxoObject.OBJ_OUTLETS, outlet);
    }

    public void removeOutlet(Outlet outlet) {
        removeUndoableElementFromList(AxoObject.OBJ_OUTLETS, outlet);
    }

}
