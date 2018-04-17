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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.ReferenceList;
import fr.paris.lutece.util.sql.DAOUtil;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides Data Access methods for Step objects
 */
public final class StepDAO implements IStepDAO
{
    // Constants
    private static final String SQL_QUERY_SELECT = "SELECT id_step, title, description, id_form FROM forms_step WHERE id_step = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO forms_step ( title, description, id_form ) VALUES ( ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM forms_step WHERE id_step = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE forms_step SET id_step = ?, title = ?, description = ?, id_form = ? WHERE id_step = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_step, title, description, id_form FROM forms_step";
    private static final String SQL_QUERY_SELECTALL_ID = "SELECT id_step FROM forms_step";

    /**
     * {@inheritDoc }
     */
    @Override
    public void insert( Step step, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, Statement.RETURN_GENERATED_KEYS, plugin );
        try
        {
            int nIndex = 1;
            daoUtil.setString( nIndex++, step.getTitle( ) );
            daoUtil.setString( nIndex++, step.getDescription( ) );
            daoUtil.setInt( nIndex++, step.getIdForm( ) );

            daoUtil.executeUpdate( );
            if ( daoUtil.nextGeneratedKey( ) )
            {
                step.setId( daoUtil.getGeneratedKeyInt( 1 ) );
            }
        }
        finally
        {
            daoUtil.free( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Step load( int nKey, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1, nKey );
        daoUtil.executeQuery( );
        Step step = null;

        if ( daoUtil.next( ) )
        {
            step = new Step( );
            int nIndex = 1;

            step.setId( daoUtil.getInt( nIndex++ ) );
            step.setTitle( daoUtil.getString( nIndex++ ) );
            step.setDescription( daoUtil.getString( nIndex++ ) );
            step.setIdForm( daoUtil.getInt( nIndex++ ) );
        }

        daoUtil.free( );
        return step;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void delete( int nKey, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nKey );
        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void store( Step step, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );
        int nIndex = 1;

        daoUtil.setInt( nIndex++, step.getId( ) );
        daoUtil.setString( nIndex++, step.getTitle( ) );
        daoUtil.setString( nIndex++, step.getDescription( ) );
        daoUtil.setInt( nIndex++, step.getIdForm( ) );
        daoUtil.setInt( nIndex, step.getId( ) );

        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Step> selectStepsList( Plugin plugin )
    {
        List<Step> stepList = new ArrayList<Step>( );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery( );

        while ( daoUtil.next( ) )
        {
            Step step = new Step( );
            int nIndex = 1;

            step.setId( daoUtil.getInt( nIndex++ ) );
            step.setTitle( daoUtil.getString( nIndex++ ) );
            step.setDescription( daoUtil.getString( nIndex++ ) );
            step.setIdForm( daoUtil.getInt( nIndex++ ) );

            stepList.add( step );
        }

        daoUtil.free( );
        return stepList;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Integer> selectIdStepsList( Plugin plugin )
    {
        List<Integer> stepList = new ArrayList<Integer>( );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL_ID, plugin );
        daoUtil.executeQuery( );

        while ( daoUtil.next( ) )
        {
            stepList.add( daoUtil.getInt( 1 ) );
        }

        daoUtil.free( );
        return stepList;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public ReferenceList selectStepsReferenceList( Plugin plugin )
    {
        ReferenceList stepList = new ReferenceList( );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery( );

        while ( daoUtil.next( ) )
        {
            stepList.addItem( daoUtil.getInt( 1 ), daoUtil.getString( 2 ) );
        }

        daoUtil.free( );
        return stepList;
    }
}
