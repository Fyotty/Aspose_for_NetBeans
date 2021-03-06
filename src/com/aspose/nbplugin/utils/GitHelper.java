/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.nbplugin.utils;

import java.io.File;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.internal.storage.file.FileRepository;

/**
 *
 * @author Administrator
 */
public class GitHelper {
    private static void updateRepository(String localPath, String remotePath) throws Exception
	{        
		Repository localRepo;
		try
		{
			localRepo = new FileRepository(localPath + "/.git");

			Git git = new Git(localRepo);
			{AsposeConstants.println("Cloning Repository [" + remotePath + "]....");}

			// First try to clone the repository
			try
			{
				Git.cloneRepository().setURI(remotePath).setDirectory(new File(localPath)).call();
			}
			catch(Exception ex)
			{
				// If clone fails, try to pull the changes
				try
				{
					git.pull().call();
				}
				catch(Exception exPull)
				{
					// Pull also failed. Throw this exception to caller
					{AsposeConstants.println("Pull also failed.");}
					throw exPull; // throw it
				}
			}
		}
		catch(Exception ex)
		{
			throw new Exception("Could not download Repository from Github. Error: " + ex.getMessage());
		}
	}

	/**
	 * 
	 * @param folderPath
	 */
	public static void checkAndCreateFolder(String folderPath) 
	{
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	/**
	 * 
	 * @param component
	 */
	public static void updateRepository(AsposeJavaComponent component)
	{
		checkAndCreateFolder(getLocalRepositoryPath(component));
		try {
			updateRepository(getLocalRepositoryPath(component), component.get_remoteExamplesRepository());
		} catch (Exception e) {
		}
	}
	
	/**
	 * 
	 * @param component
	 * @return
	 */
	public static boolean isExamplesDefinitionsPresent(AsposeJavaComponent component)
	{
		File file = new File(getLocalRepositoryPath(component) + File.separator + "Examples.xml");
		return file.exists();
	}
	
	/**
	 * 
	 * @param component
	 * @return
	 */
	public static String getExamplesDefinitionsPath(AsposeJavaComponent component)
	{
		return getLocalRepositoryPath(component) + File.separator + "Examples.xml";
	}
	
	/**
	 * 
	 * @param component
	 * @return
	 */
	public static String  getLocalRepositoryPath(AsposeJavaComponent component)
	{
		return AsposeComponentsManager.getAsposeHomePath() +  "GitSampleRepos" + File.separator + component.get_name();
	}

}
