package io.github.mmc1234.fancyui.yoga;

import com.google.common.base.Preconditions;
import io.github.mmc1234.fancyui.yoga.internal.Native;
import jdk.incubator.foreign.ResourceScope;
import org.lwjgl.util.yoga.YGNode;
import org.lwjgl.util.yoga.Yoga;

import java.lang.ref.WeakReference;
import java.util.List;

public class YogaNode implements Cloneable {
    private long _ygNode;
    private YogaConfig _config;
    private WeakReference<YogaNode> _parent;
    private List<YogaNode> _children;
    private MeasureFunction _measureFunction;
    private BaselineFunction _baselineFunction;
    private Object _data;
    private ResourceScope scope;


    public YogaNode() {
        this(YogaConfig.getDefault(), ResourceScope.globalScope());
    }

    public YogaNode(YogaNode srcNode) {
        this(srcNode._config, srcNode.scope);
        copyStyle(srcNode);
    }

    public YogaNode(YogaConfig config, ResourceScope scope) {
        this.scope = scope;
        this._config = config;
        _ygNode = Native.YGNodeNewWithConfig(_config.toRawLongValue());
        Preconditions.checkState(!isNull(), "Failed to allocate native memory");
        scope.addCloseAction(this::destruction);
    }

    private void destruction() {
        if(isNull()) return;
        Yoga.nYGNodeFree(toRawLongValue());
    }

    public void reset() {
        _measureFunction = null;
        _baselineFunction = null;
        _data = null;
        Yoga.nYGNodeReset(toRawLongValue());
    }

    public YogaConfig getConfig() {
        return _config;
    }

    public void setConfig(YogaConfig config) {
        this._config = config == null ? YogaConfig.getDefault() : config;
        Native.YGNodeSetConfig(toRawLongValue(), config.toRawLongValue());
    }

    public boolean isDirty() {
        return YGNode.nisDirty(toRawLongValue());
    }

    public void markDirty() {
        YGNode.nisDirty(toRawLongValue(), true);
    }

    public boolean hasNewLayout() {
        return YGNode.nhasNewLayout(toRawLongValue());
    }

    public void markHasNewLayout() {
        YGNode.nhasNewLayout(toRawLongValue(), true);
    }

    public YogaNode getParent() {
        return _parent.get();
    }

    public boolean isMeasureDefined() {
        return _measureFunction != null;
    }

    public boolean isBaselineDefined() {
        return _baselineFunction != null;
    }

    public void copyStyle(YogaNode srcNode) {
        Yoga.YGNodeCopyStyle(toRawLongValue(), srcNode.toRawLongValue());
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.valueOf(Yoga.nYGNodeStyleGetDirection(toRawLongValue()));
    }

    public void setStyleDirection(YogaDirection value) {
        Yoga.YGNodeStyleSetDirection(toRawLongValue(),
                value == null ?
                YogaDirection.values()[0].value() : value.value());
    }

    public YogaFlexDirection getFlexDirection() {

        return YogaFlexDirection.valueOf(Yoga.nYGNodeStyleGetFlexDirection(toRawLongValue()));
    }

    public void setFlexDirection(YogaFlexDirection value) {
        Native.YGNodeStyleSetFlexDirection(_ygNode, value);
    }

    public YogaJustify getJustifyContent() {
        return Native.YGNodeStyleGetJustifyContent(_ygNode);
    }

    public void setJustifyContent(YogaJustify value) {
        Native.YGNodeStyleSetJustifyContent(_ygNode, value);
    }

    public YogaDisplay getDisplay() {
        return Native.YGNodeStyleGetDisplay(_ygNode);
    }

    public void setDisplay(YogaDisplay display) {
        Native.YGNodeStyleSetDisplay(_ygNode, display);
    }

    public void setWidth(YogaValue value) {
        switch (value.unit()) {
            case POINT -> Yoga.nYGNodeStyleSetWidth(_ygNode, value.value());
            case PERCENT -> Yoga.nYGNodeStyleSetWidthPercent(_ygNode, value.value());
            case UNDEFINED, AUTO -> Yoga.nYGNodeStyleSetWidthAuto(_ygNode);
        }
    }

    public void setWidth(String v) {
        setWidth(YogaValue.parse(v));
    }

    public void setHeight(YogaValue value) {
        switch (value.unit()) {
            case POINT -> Yoga.nYGNodeStyleSetHeight(_ygNode, value.value());
            case PERCENT -> Yoga.nYGNodeStyleSetHeightPercent(_ygNode, value.value());
            case UNDEFINED, AUTO -> Yoga.nYGNodeStyleSetHeightAuto(_ygNode);
        }
    }

    public void setHeight(String v) {
        setHeight(YogaValue.parse(v));
    }

    public void calculateLayout(float aw, float ah, YogaDirection ownerDirection) {
        Yoga.nYGNodeCalculateLayout(_ygNode, aw, ah, ownerDirection.value());
    }

    public float getLayoutX() {
        return Yoga.nYGNodeLayoutGetLeft(_ygNode);
    }

    public float getLayoutY() {
        return Yoga.nYGNodeLayoutGetTop(_ygNode);
    }
    public float getLayoutWidth() {
        return Yoga.nYGNodeLayoutGetWidth(_ygNode);
    }

    public float getLayoutHeight() {
        return Yoga.nYGNodeLayoutGetHeight(_ygNode);
    }


    public long toRawLongValue() {
        return _ygNode;
    }

    private boolean isNull() {
        return _ygNode == 0L;
    }
}
