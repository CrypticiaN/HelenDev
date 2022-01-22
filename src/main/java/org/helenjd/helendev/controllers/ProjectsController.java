package org.helenjd.helendev.controllers;

import org.helenjd.helendev.repositories.Projects;
import org.helenjd.helendev.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectsController {

    private ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsController(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @GetMapping("/projects")
    String listProjects(Model model) {
        List<Projects> projects = (List<Projects>) projectsRepository.findAll();
        model.addAttribute("project", "projects list");
        model.addAttribute("projects", projects);
        return "projects/all";
    }
}
