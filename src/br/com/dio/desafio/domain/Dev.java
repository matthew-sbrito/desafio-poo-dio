package br.com.dio.desafio.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Dev {
    private String name;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> completedContent = new LinkedHashSet<>();

    public void registerBootcamp(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void toProgress() {
        Optional<Content> content = this.subscribedContent.stream().findFirst();

        if(content.isPresent()) {
            this.completedContent.add(content.get());
            this.subscribedContent.remove(content.get());
            return;
        }

        System.err.println("You aren't enrolled in any content!");
    }

    public double calculateTotalXp() {
        return this.completedContent
                .stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getCompletedContent() {
        return completedContent;
    }

    public void setCompletedContent(Set<Content> completedContent) {
        this.completedContent = completedContent;
    }

    private List<String> getContentListString(List<Content> contentList) {
        return contentList
                .stream()
                .map(Content::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getSubscribedContentString() {
        return getContentListString(
                new ArrayList<>(getSubscribedContent())
        );
    }

    public List<String> getCompletedContentString() {
        return getContentListString(
                new ArrayList<>(getCompletedContent())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) &&
                Objects.equals(subscribedContent, dev.subscribedContent) &&
                Objects.equals(completedContent, dev.completedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContent, completedContent);
    }
}
