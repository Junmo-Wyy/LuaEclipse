package org.keplerproject.ldt.internal.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class LuaApplicationLaunchConfigurationDelegate
    implements ILaunchConfigurationDelegate
{

	protected static final InterpreterRunner interpreterRunner = new InterpreterRunner();
	public static final String TYPE_ID = "luaeclipse.launching.LaunchConfigurationTypeLuaApplication";
    public LuaApplicationLaunchConfigurationDelegate()
    {
    }

    public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
        throws CoreException
    {
        if(LuaRuntime.getDefault().getSelectedInterpreter() == null)
            throw new CoreException(new Status(4, "org.keplerproject.launching.ui", 0, "You must define an interpreter before running Lua Applications.", null));
        if(!mode.equals("debug"))
            interpreterRunner.run(new InterpreterRunnerConfiguration(configuration), launch);
    }



}