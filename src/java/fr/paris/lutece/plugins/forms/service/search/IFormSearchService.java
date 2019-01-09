/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.forms.service.search;

import fr.paris.lutece.plugins.forms.business.form.search.IndexerAction;
import fr.paris.lutece.portal.service.plugin.Plugin;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface IFormSearchService
{
    List<Integer> getSearchResults( FormSearchConfig formSearchConfig );

    String processIndexing( boolean bCreate );

    void addIndexerAction( int nIdFormResponse, int nIdTask, Plugin plugin );

    void removeIndexerAction( int nIdAction, Plugin plugin );

    List<IndexerAction> getAllIndexerActionByTask( int nIdTask, Plugin plugin );

}
