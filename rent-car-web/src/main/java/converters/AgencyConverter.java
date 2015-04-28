package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mBeans.AgencyBean;
import domain.Agency;

@FacesConverter("ac")
public class AgencyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null) {
			return null;
		}
		AgencyBean agencyBean = context.getApplication().evaluateExpressionGet(
				context, "#{agencyBean}", AgencyBean.class);
		Agency agency = agencyBean.doFindAgencyByName(string);

		return agency;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Agency) {
			string = ((Agency) object).getName();
		}
		return string;
	}

}
