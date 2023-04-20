import annotations.Convert;
import service.StringConverter;

module StringConvertClient {
    requires StringConverterService;
    uses StringConverter;
    uses Convert;
}
