/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package org.smark.mkp.rap.v21.webapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ExampleCategory {

  private final String name;
  private final ArrayList<String> contributionIds;

  public ExampleCategory( String name ) {
    this.name = name;
    contributionIds = new ArrayList<String>();
  }

  public String getName() {
    return name;
  }

  public List<String> getContributionIds() {
    return Collections.unmodifiableList( contributionIds );
  }

  void addContributionId( String contributionId ) {
    contributionIds.add( contributionId );
  }

}
