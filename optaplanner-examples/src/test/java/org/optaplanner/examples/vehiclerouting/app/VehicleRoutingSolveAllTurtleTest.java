/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.vehiclerouting.app;

import java.io.File;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.examples.common.app.ImportDirSolveAllTurtleTest;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.vehiclerouting.persistence.VehicleRoutingImporter;
import org.optaplanner.examples.vehiclerouting.solver.score.VehicleRoutingEasyScoreCalculator;

public class VehicleRoutingSolveAllTurtleTest extends ImportDirSolveAllTurtleTest {

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> getSolutionFilesAsParameters() {
        return getImportDirFilesAsParameters(new VehicleRoutingImporter());
    }

    public VehicleRoutingSolveAllTurtleTest(File dataFile) {
        super(dataFile);
    }

    @Override
    protected String createSolverConfigResource() {
        return "org/optaplanner/examples/vehiclerouting/solver/vehicleRoutingSolverConfig.xml";
    }

    @Override
    protected AbstractSolutionImporter createSolutionImporter() {
        return new VehicleRoutingImporter();
    }

    @Override
    protected Class<? extends EasyScoreCalculator> overwritingEasyScoreCalculatorClass() {
        return VehicleRoutingEasyScoreCalculator.class;
    }

}
