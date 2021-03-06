/*
 * Copyright (c) 2002-2018, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.forms.business;

import javax.validation.constraints.Size;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import fr.paris.lutece.portal.service.rbac.RBACResource;
import fr.paris.lutece.portal.service.workgroup.AdminWorkgroupResource;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * This is the business class for the object Form
 */
public class Form implements AdminWorkgroupResource, RBACResource
{

    /**
     * Form resource type
     */
    public static final String RESOURCE_TYPE = "FORMS_FORM";

    /**
     * State of forms that are enabled
     */
    public static final int STATE_ENABLE = 1;

    /**
     * State of forms that are disabled
     */
    public static final int STATE_DISABLE = 0;

    // Variables declarations
    private int _nId;

    @NotEmpty( message = "#i18n{forms.validation.form.Title.notEmpty}" )
    @Size( max = 255, message = "#i18n{forms.validation.form.Title.size}" )
    private String _strTitle;

    @Size( max = 255, message = "#i18n{forms.validation.form.Description.size}" )
    private String _strDescription;

    private Timestamp _dateCreation;

    private Date _dateAvailabilityStartDate;

    private Date _dateAvailabilityEndDate;

    private Timestamp _dateUpdate;

    private String _strWorkgroup;

    private List<FormAction> _listActions;

    private int _nIdWorkflow;

    private boolean _bAuthentificationNeeded;

    @NotEmpty( message = "#i18n{forms.validation.form.Breadcrumb.notEmpty}" )
    @Size( max = 255, message = "#i18n{forms.validation.form.Breadcrumb.size}" )
    private String _strBreadcrumbName;

    @Size( max = 255, message = "#i18n{forms.validation.form.ReturnUrl.size}" )
    private String _strReturnUrl;

    private boolean _bDisplaySummary;
    private int _nMaxNumberResponse;
    private boolean _bOneResponseByUser;

    /**
     * Returns the Id
     * 
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * 
     * @param nId
     *            The Id
     */
    public void setId( int nId )
    {
        _nId = nId;
    }

    /**
     * Returns the Title
     * 
     * @return The Title
     */
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * Sets the Title
     * 
     * @param strTitle
     *            The Title
     */
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }

    /**
     * Returns the Description
     * 
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * 
     * @param strDescription
     *            The Description
     */
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }

    /**
     * Returns the CreationDate
     * 
     * @return The CreationDate
     */
    public Timestamp getCreationDate( )
    {
        return _dateCreation;
    }

    /**
     * Sets the CreationDate
     * 
     * @param creationDate
     *            The CreationDate
     */
    public void setCreationDate( Timestamp creationDate )
    {
        _dateCreation = creationDate;
    }

    /**
     * Returns the UpdateDate
     * 
     * @return The UpdateDate
     */
    public Timestamp getUpdateDate( )
    {
        return _dateUpdate;
    }

    /**
     * Sets the UpdateDate
     * 
     * @param dateUpdate
     *            The UpdateDate
     */
    public void setUpdateDate( Timestamp dateUpdate )
    {

        _dateUpdate = dateUpdate;
    }

    /**
     * Returns the AvailabilityStartDate
     * 
     * @return The AvailabilityStartDate
     */
    public Date getAvailabilityStartDate( )
    {
        return _dateAvailabilityStartDate;
    }

    /**
     * Sets the AvailabilityStartDate
     * 
     * @param dateAvailabilityStartDate
     *            The AvailabilityStartDate
     */
    public void setAvailabilityStartDate( Date dateAvailabilityStartDate )
    {
        _dateAvailabilityStartDate = dateAvailabilityStartDate;
    }

    /**
     * Returns the AvailabilityEndDate
     * 
     * @return The AvailabilityEndDate
     */
    public Date getAvailabilityEndDate( )
    {
        return _dateAvailabilityEndDate;
    }

    /**
     * Sets the AvailabilityEndDate
     * 
     * @param dateAvailabilityEndDate
     *            The AvailabilityEndDate
     */
    public void setAvailabilityEndDate( Date dateAvailabilityEndDate )
    {
        _dateAvailabilityEndDate = dateAvailabilityEndDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceTypeCode( )
    {
        return RESOURCE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceId( )
    {
        return StringUtils.EMPTY + _nId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWorkgroup( )
    {
        return _strWorkgroup;
    }

    /**
     * set the work group associate to the form
     * 
     * @param workGroup
     *            the work group associate to the form
     */
    public void setWorkgroup( String workGroup )
    {
        _strWorkgroup = workGroup;
    }

    /**
     *
     * @return a list of action can be use for the form
     */
    public List<FormAction> getActions( )
    {
        return _listActions;
    }

    /**
     * set a list of action can be use for the form
     * 
     * @param formActions
     *            a list of action must be use for the form
     */
    public void setActions( List<FormAction> formActions )
    {
        _listActions = formActions;
    }

    /**
     * Returns the active status of a form by checking if we are currently within its availability period
     * 
     * @return true if the form is active
     */
    public boolean isActive( )
    {
        boolean bActive = false;
        Date dToday = new Date( System.currentTimeMillis( ) );

        if ( _dateAvailabilityStartDate != null && _dateAvailabilityStartDate.before( dToday )
                && ( _dateAvailabilityEndDate == null || _dateAvailabilityEndDate.after( dToday ) ) )
        {
            bActive = true;
        }
        if ( _dateAvailabilityStartDate == null && ( _dateAvailabilityEndDate != null && _dateAvailabilityEndDate.after( dToday ) ) )
        {
            bActive = true;
        }

        return bActive;
    }

    /**
     * Getter for id_workflow
     * 
     * @return the _nIdWorkflow
     */
    public int getIdWorkflow( )
    {
        return _nIdWorkflow;
    }

    /**
     * setter for id_workflow
     * 
     * @param nIdWorkflow
     *            the Id Workflow to set
     */
    public void setIdWorkflow( int nIdWorkflow )
    {
        _nIdWorkflow = nIdWorkflow;
    }

    /**
     * @return the _bAuthentificationNeeded
     */
    public boolean isAuthentificationNeeded( )
    {
        return _bAuthentificationNeeded;
    }

    /**
     * @param bAuthentificationNeeded
     *            the bAuthentificationNeeded to set
     */
    public void setAuthentificationNeeded( boolean bAuthentificationNeeded )
    {
        this._bAuthentificationNeeded = bAuthentificationNeeded;
    }

    /**
     * Returns the BreadcrumbName
     * 
     * @return The BreadcrumbName
     */
    public String getBreadcrumbName( )
    {
        return _strBreadcrumbName;
    }

    /**
     * Sets the Title
     * 
     * @param strBreadcrumbName
     *            The breadcrumb bean name
     */
    public void setBreadcrumbName( String strBreadcrumbName )
    {
        _strBreadcrumbName = strBreadcrumbName;
    }

    /**
     * Returns the return URL
     * 
     * @return The return URL
     */
    public String getReturnUrl( )
    {
        return _strReturnUrl;
    }

    /**
     * Sets the return URL
     * 
     * @param strReturnUrl
     *            The form return page URL
     */
    public void setReturnUrl( String strReturnUrl )
    {
        _strReturnUrl = strReturnUrl;
    }

    /**
     * Tells if the summary must be displayed
     * 
     * @return {@code true} if the summary must be displayed, {@code false} otherwise
     */
    public boolean isDisplaySummary( )
    {
        return _bDisplaySummary;
    }

    /**
     * Sets if the summary must be displayed
     * 
     * @param bDisplaySummary
     *            {@code true} if the summary must be displayed, {@code false} otherwise
     */
    public void setDisplaySummary( boolean bDisplaySummary )
    {
        _bDisplaySummary = bDisplaySummary;
    }

    /**
     * Returns the number Max of response form
     * 
     * @return The number max of reponse for
     */
    public int getMaxNumberResponse( )
    {
        return _nMaxNumberResponse;
    }

    /**
     * Sets the number Max of response form
     * 
     * @param nMaxNumberResponse
     *            The number max of reponse form
     */
    public void setMaxNumberResponse( int nMaxNumberResponse )
    {
        _nMaxNumberResponse = nMaxNumberResponse;
    }

    /**
     * Check the user can only submit one form.
     * 
     * @return true if the user can submit just one form
     */
    public boolean isOneResponseByUser( )
    {
        return _bOneResponseByUser;
    }

    /**
     * set true if the user can submit just once the form
     * 
     * @param bOneResponseByUser
     *            true if the user can submit just one form
     */
    public void setOneResponseByUser( boolean bOneResponseByUser )
    {
        _bOneResponseByUser = bOneResponseByUser;
    }
}
