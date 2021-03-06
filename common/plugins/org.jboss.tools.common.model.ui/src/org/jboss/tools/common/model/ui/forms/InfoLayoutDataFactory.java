/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.common.model.ui.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

/**
 * @author Igels
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class InfoLayoutDataFactory implements ILayoutDataFactory {
	int height = 60;

	private static InfoLayoutDataFactory INSTANCE = new InfoLayoutDataFactory(60);

	private static InfoLayoutDataFactory HIGH_INSTANCE = new InfoLayoutDataFactory(120);

	private InfoLayoutDataFactory(int height) {
		this.height = height;
	}

	public static InfoLayoutDataFactory getInstance() {
		return INSTANCE;
	}

	public static InfoLayoutDataFactory getHighInstance() {
		return HIGH_INSTANCE;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.common.model.ui.forms.ILayoutDataFactory#createLayoutData(org.jboss.tools.common.model.ui.forms.AttributeControlType)
	 */
	public Object createLayoutData(AttributeControlType type) {
		if(type == AttributeControlType.LABEL) {
			GridData gd = new GridData();
			gd.verticalAlignment = SWT.UP;
			return gd;
		} else if(type == AttributeControlType.EDITOR) {
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.heightHint = height;
			return gd;
		}
		throw new FormRuntimeException("Attribute control type may be only Label or Editor but this is " + type);
	}
}