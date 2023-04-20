import converter.FirstThreeBold;
import converter.WholeBold;
import service.StringConverter;

module StringConverter {
    requires StringConverterService;
    provides StringConverter with FirstThreeBold, WholeBold;
}
