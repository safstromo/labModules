import converter.FirstThreeBold;
import service.StringConverter;

module StringConverter {

    requires StringConverterService;
    provides StringConverter with FirstThreeBold;
}
