package may.code.crazy.task.tracker.api.controllers.helpers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import may.code.crazy.task.tracker.api.exceptions.NotFoundException;
import may.code.crazy.task.tracker.store.entities.ProjectEntity;
import may.code.crazy.task.tracker.store.repositories.ProjectRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
@Transactional
public class ControllerHelper {

    ProjectRepository projectRepository;

    public ProjectEntity getProjectOrThrowException(Long projectId) {

        return projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format(
                                        "Project with \"%s\" doesn't exist.",
                                        projectId
                                )
                        )
                );
    }
}
