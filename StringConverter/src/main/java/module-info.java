import converter.ThreeBold;
import service.StringConverter;

module StringConverter {

    requires StringConverterService;
    provides StringConverter with ThreeBold;
}
