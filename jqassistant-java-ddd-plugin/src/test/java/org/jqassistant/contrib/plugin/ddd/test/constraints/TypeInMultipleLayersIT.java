package org.jqassistant.contrib.plugin.ddd.test.constraints;

import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Constraint;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.plugin.java.test.AbstractJavaPluginIT;
import org.jqassistant.contrib.plugin.ddd.test.set.violation.layer1.Layer;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeInMultipleLayersIT extends AbstractJavaPluginIT {

    @Test
    public void testTypeInMultipleBoundedContexts() throws RuleException {
        scanClassPathDirectory(getClassesDirectory(Layer.class));
        //assertEquals(applyConcept("java-ddd:BoundedContextType").getStatus(), Result.Status.SUCCESS);
        //assertEquals(applyConcept("java-ddd:BoundedContextPackage").getStatus(), Result.Status.SUCCESS);
        Result<Constraint> result = validateConstraint("java-ddd:TypeInMultipleLayers");
        assertEquals(1, result.getRows().size());
        Map<String, Object> row = result.getRows().get(0);
        assertEquals(row.get("Type"), "org.jqassistant.contrib.plugin.ddd.test.set.violation.layer1.Layer");
    }
}
